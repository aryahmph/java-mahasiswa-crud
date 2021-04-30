package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {

  @Test
  void testAddMahasiswa() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    Mahasiswa mahasiswa = new Mahasiswa("Yunanta", "09021182025000", "yunanta@test.com");
    mahasiswaRepository.add(mahasiswa);
  }

}
