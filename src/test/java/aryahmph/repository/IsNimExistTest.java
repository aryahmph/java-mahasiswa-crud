package aryahmph.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsNimExistTest {
  @Test
  void testIsNimExist() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    boolean mahasiswa = mahasiswaRepository.isNimExist("09021182025009");
    Assertions.assertEquals(true, mahasiswa);
  }

  @Test
  void testIsNimExist2() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    boolean mahasiswa = mahasiswaRepository.isNimExist("0000");
    Assertions.assertEquals(false, mahasiswa);
  }
}
