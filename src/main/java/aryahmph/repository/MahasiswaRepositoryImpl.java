package aryahmph.repository;

import aryahmph.entity.Mahasiswa;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepositoryImpl implements MahasiswaRepository {

  private DataSource dataSource;

  public MahasiswaRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void add(Mahasiswa mahasiswa) {
    String sql = "INSERT INTO mahasiswa(id,name,nim,email) VALUES(?,?,?,?)";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setInt(1, mahasiswa.getId());
      statement.setString(2, mahasiswa.getName());
      statement.setString(3, mahasiswa.getNim());
      statement.setString(4, mahasiswa.getEmail());

      statement.executeUpdate();
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean remove(int id) {
    if (isExist(id)) {
      String sql = "DELETE FROM mahasiswa WHERE id = ?";
      try (Connection connection = dataSource.getConnection();
           PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        int delete = statement.executeUpdate();
        return delete == 1;

      } catch (SQLException exception) {
        throw new RuntimeException(exception);
      }
    } else {
      return false;
    }
  }

  @Override
  public boolean isExist(int id) {
    String sql = "SELECT id FROM mahasiswa WHERE id=?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        return resultSet.next();
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public Mahasiswa findByNim(String nim) {
    String sql = "SELECT * FROM mahasiswa WHERE nim=?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setString(1, nim);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          return new Mahasiswa(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("nim"),
            resultSet.getString("email")
          );
        } else {
          return null;
        }
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public List<Mahasiswa> findAll() {
    List<Mahasiswa> list = new ArrayList<>();
    String sql = "SELECT * FROM mahasiswa";
    try (Connection connection = dataSource.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {

      while (resultSet.next()) {
        list.add(new Mahasiswa(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getString("nim"),
          resultSet.getString("email")
        ));
      }
      return list;

    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean isNimExist(String nim) {
    if (nim.length() > 14) return false;
    String sql = "SELECT id FROM mahasiswa WHERE nim=?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, nim);

      try (ResultSet resultSet = statement.executeQuery()) {
        return resultSet.next();
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean isEmailExist(String email) {
    String sql = "SELECT id FROM mahasiswa WHERE email=?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setString(1, email);
      try (ResultSet resultSet = statement.executeQuery()) {
        return resultSet.next();
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }


}
