package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import aryahmph.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepositoryImpl implements MahasiswaRepository {

  @Override
  public void add(Mahasiswa mahasiswa) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "INSERT INTO mahasiswa(name,nim,email) VALUES(?,?,?)";

      try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, mahasiswa.getName());
        statement.setString(2, mahasiswa.getNim());
        statement.setString(3, mahasiswa.getEmail());

        statement.executeUpdate();
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  /**
   * @return Mahasiswa or Null
   * <p>
   * Mengembalikan satu nim, karena nim tidak boleh duplikat.
   * Jika tidak ditemukan, kembalikan null;
   */
  @Override
  public Mahasiswa findByNim(String nim) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "SELECT * FROM mahasiswa WHERE nim=?";
      try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nim);
        try (ResultSet resultSet = statement.executeQuery()) {
          if (resultSet.next()) {
            return new Mahasiswa(
              resultSet.getString("name"),
              resultSet.getString("nim"),
              resultSet.getString("email")
            );
          } else {
            return null;
          }
        }
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public List<Mahasiswa> findAll() {
    List<Mahasiswa> list = new ArrayList<>();

    try (Connection connection = ConnectionUtil.getDataSource().getConnection();
         Statement statement = connection.createStatement()) {
      String sql = "SELECT * FROM mahasiswa";
      try (ResultSet resultSet = statement.executeQuery(sql)) {
        while (resultSet.next()) {
          list.add(new Mahasiswa(
            resultSet.getString("name"),
            resultSet.getString("nim"),
            resultSet.getString("email")
          ));
        }
        return list;
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean isNimExist(String nim) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "SELECT id FROM mahasiswa WHERE nim=?";
      try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nim);
        try (ResultSet resultSet = statement.executeQuery()) {
          if (resultSet.next()) {
            return true;
          } else {
            return false;
          }
        }
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean isEmailExist(String email) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "SELECT id FROM mahasiswa WHERE email=?";
      try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, email);
        try (ResultSet resultSet = statement.executeQuery()) {
          if (resultSet.next()) {
            return true;
          } else {
            return false;
          }
        }
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean remove(String nim) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection();
         Statement statement = connection.createStatement()) {
      String sql = "DELETE FROM mahasiswa WHERE nim ='" + nim + "'";
      int deleted = statement.executeUpdate(sql);
      if (deleted == 1) return true;
      else return false;
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

}
