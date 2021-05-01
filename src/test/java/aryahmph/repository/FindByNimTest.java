package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import org.junit.jupiter.api.Test;

public class FindByNimTest {

  @Test
  void testFindByNimTest() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    Mahasiswa mahasiswa = mahasiswaRepository.findByNim("09021182025009");
    System.out.println(mahasiswa);
  }
}
