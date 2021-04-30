package aryahmph.repository;

import aryahmph.entity.Mahasiswa;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindAllTest {

  @Test
  void testFindAll() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.findAll();
    System.out.println(mahasiswaList);
  }
}
