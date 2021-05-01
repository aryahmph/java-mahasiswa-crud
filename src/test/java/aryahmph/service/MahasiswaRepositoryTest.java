package aryahmph.service;

import aryahmph.repository.MahasiswaRepository;
import aryahmph.repository.MahasiswaRepositoryImpl;
import org.junit.jupiter.api.Test;

public class MahasiswaRepositoryTest {

  MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
  MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);

  @Test
  void testShowMahasiswa() {
    mahasiswaService.showMahasiswa();
  }

  @Test
  void testAddMahasiswa() {
    mahasiswaService.showMahasiswa();
    mahasiswaService.addMahasiswa("Gandi", "090909", "gandi@test.com");
    mahasiswaService.showMahasiswa();

  }
}
