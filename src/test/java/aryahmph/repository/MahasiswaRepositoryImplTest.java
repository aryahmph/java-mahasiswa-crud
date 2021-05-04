package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import aryahmph.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MahasiswaRepositoryImplTest {
  private HikariDataSource dataSource;
  private MahasiswaRepository mahasiswaRepository;

  @BeforeEach
  void setUp() {
    dataSource = DatabaseUtil.getDataSource();
    mahasiswaRepository = new MahasiswaRepositoryImpl(dataSource);
  }

  @Test
  void testAdd() {
    Mahasiswa mahasiswa = new Mahasiswa("Gandi Subara", "09020082025009", "gandi@test.com");
    mahasiswaRepository.add(mahasiswa);
  }

  @Test
  void testRemove() {
    boolean delete = mahasiswaRepository.remove(5);
    Assertions.assertEquals(true, delete);
  }

  @Test
  void testAddAndRemove() {
    mahasiswaRepository.remove(2);
    Mahasiswa mahasiswa = new Mahasiswa("Arya Yunanta", "09021182025009", "arya@test.com");
    mahasiswaRepository.add(mahasiswa);
  }

  @AfterEach
  void tearDown() {
    dataSource.close();
  }
}
