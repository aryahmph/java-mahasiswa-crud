package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import aryahmph.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  @Override
  public Mahasiswa findByNIM(String nim) {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "SELECT * FROM mahasiswa WHERE nim=?";
      try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nim);
        try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            String name = resultSet.getString("name");
          }
        }

      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
    return null;
  }

  @Override
  public List<Mahasiswa> findAll() {
    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {

    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
    return null;
  }
}
