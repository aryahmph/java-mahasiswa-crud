package aryahmph.service;

import aryahmph.repository.MahasiswaRepository;
import aryahmph.repository.MahasiswaRepositoryImpl;
import org.junit.jupiter.api.Test;

public class MahasiswaRepositoryTest {

  @Test
  void testShowTodoList() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);

    mahasiswaService.showMahasiswa();
  }
}
