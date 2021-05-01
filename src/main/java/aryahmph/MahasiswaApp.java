package aryahmph;

import aryahmph.repository.MahasiswaRepository;
import aryahmph.repository.MahasiswaRepositoryImpl;
import aryahmph.service.MahasiswaService;
import aryahmph.service.MahasiswaServiceImpl;
import aryahmph.view.MahasiswaView;

public class MahasiswaApp {
  public static void main(String[] args) {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);
    MahasiswaView mahasiswaView = new MahasiswaView(mahasiswaService);
    mahasiswaView.showMahasiswa();
  }
}
