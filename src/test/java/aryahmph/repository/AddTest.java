package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import org.junit.jupiter.api.Test;

public class AddTest {

  @Test
  void testAddMahasiswa() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    Mahasiswa mahasiswa = new Mahasiswa("Yunanta", "090211820250000000000", "yunanta2@test.com");
    mahasiswaRepository.add(mahasiswa);
  }

}
