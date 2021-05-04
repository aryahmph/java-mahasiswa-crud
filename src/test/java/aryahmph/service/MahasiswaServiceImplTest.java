package aryahmph.service;

import aryahmph.repository.MahasiswaRepositoryImpl;
import aryahmph.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MahasiswaServiceImplTest {

  private HikariDataSource dataSource;
  private MahasiswaService mahasiswaService;

  @BeforeEach
  void setUp() {
    dataSource = DatabaseUtil.getDataSource();
    mahasiswaService = new MahasiswaServiceImpl(new MahasiswaRepositoryImpl(dataSource));
  }

  @Test
  void testAdd() {
    mahasiswaService.addMahasiswa("Gandi Subara", "090211820", "gandi@test.com");
  }

  @AfterEach
  void tearDown() {
    dataSource.close();
  }

}
