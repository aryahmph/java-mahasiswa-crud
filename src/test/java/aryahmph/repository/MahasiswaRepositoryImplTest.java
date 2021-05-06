//package aryahmph.repository;
//
//import aryahmph.entity.Mahasiswa;
//import aryahmph.util.DatabaseUtil;
//import com.zaxxer.hikari.HikariDataSource;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//
//public class MahasiswaRepositoryImplTest {
//  private HikariDataSource dataSource;
//  private MahasiswaRepository mahasiswaRepository;
//
//  @BeforeEach
//  void setUp() {
//    dataSource = DatabaseUtil.getDataSource();
//    mahasiswaRepository = new MahasiswaRepositoryImpl(dataSource);
//  }
//
//  @Test
//  void testAdd() {
//    Mahasiswa mahasiswa = new Mahasiswa("Tamir Gading", "09082025009", "gading@test.com");
//    mahasiswaRepository.add(mahasiswa);
//  }
//
//  @Test
//  void testRemove() {
//  }
//
//
//  @Test
//  void testFindAll() {
//    List<Mahasiswa> list = mahasiswaRepository.findAll();
//    for (Mahasiswa mahasiswa : list) {
//      System.out.println(mahasiswa);
//    }
//  }
//
//  @Test
//  void testFindById() {
//    Mahasiswa mahasiswa = mahasiswaRepository.findById(2);
//    System.out.println(mahasiswa);
//  }
//
//  @Test
//  void testFind() {
//    List<Mahasiswa> mahasiswaList = mahasiswaRepository.find("arya");
//    for (Mahasiswa mahasiswa : mahasiswaList) {
//      System.out.println(mahasiswa);
//    }
//  }
//
//  @Test
//  void testUpdate() {
//
//  }
//
//  @AfterEach
//  void tearDown() {
//    dataSource.close();
//  }
//}
