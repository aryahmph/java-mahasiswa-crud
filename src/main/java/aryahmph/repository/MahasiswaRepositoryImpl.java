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

    try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
      String sql = "SELECT * FROM mahasiswa";
      try (Statement statement = connection.createStatement()) {
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
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

}
