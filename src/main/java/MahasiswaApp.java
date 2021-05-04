import aryahmph.repository.MahasiswaRepository;
import aryahmph.repository.MahasiswaRepositoryImpl;
import aryahmph.service.MahasiswaService;
import aryahmph.service.MahasiswaServiceImpl;
import aryahmph.util.DatabaseUtil;
import aryahmph.view.MahasiswaView;

import javax.sql.DataSource;

public class MahasiswaApp {
  public static void main(String[] args) {
    DataSource dataSource = DatabaseUtil.getDataSource();
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl(dataSource);
    MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);
    MahasiswaView mahasiswaView = new MahasiswaView(mahasiswaService);
    mahasiswaView.showMahasiswa();
  }
}
