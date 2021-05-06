//package aryahmph.service;
//
//import aryahmph.repository.MahasiswaRepositoryImpl;
//import aryahmph.util.DatabaseUtil;
//import com.zaxxer.hikari.HikariDataSource;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class MahasiswaServiceImplTest {
//
//  private HikariDataSource dataSource;
//  private MahasiswaService mahasiswaService;
//
//  @BeforeEach
//  void setUp() {
//    dataSource = DatabaseUtil.getDataSource();
//    mahasiswaService = new MahasiswaServiceImpl(new MahasiswaRepositoryImpl(dataSource));
//  }
//
//  @Test
//  void testAdd() {
//    mahasiswaService.addMahasiswa("Gandi Subara", "09021182025008", "gandi@test.com");
//  }
//
//  @Test
//  void testRemove() {
//  }
//
//  @Test
//  void testShowMahasiswa() {
//    mahasiswaService.showMahasiswa();
//  }
//
//  @Test
//  void testSearchMahasiswa() {
//    mahasiswaService.searchMahasiswa("arya");
//  }
//
//  @Test
//  void testUpdateMahasiswa() {
//
//  }
//
//  @AfterEach
//  void tearDown() {
//    dataSource.close();
//  }
//
//}
