package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import org.junit.jupiter.api.Test;

public class findByNimTest {

  @Test
  void testFindByNimTest() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    Mahasiswa mahasiswa = mahasiswaRepository.findByNim("0902118202509");
    System.out.println(mahasiswa);
  }
}
