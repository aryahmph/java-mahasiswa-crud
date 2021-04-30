package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import aryahmph.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    return null;
  }

  @Override
  public List<Mahasiswa> findAll() {
    return null;
  }
}
