package aryahmph.view;

import aryahmph.repository.MahasiswaRepository;
import aryahmph.repository.MahasiswaRepositoryImpl;
import aryahmph.service.MahasiswaService;
import aryahmph.service.MahasiswaServiceImpl;
import org.junit.jupiter.api.Test;

public class MahasiswaViewTest {


  @Test
  void testShowMahasiswa() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);
    MahasiswaView mahasiswaView = new MahasiswaView(mahasiswaService);
    mahasiswaView.showMahasiswa();
  }
}
