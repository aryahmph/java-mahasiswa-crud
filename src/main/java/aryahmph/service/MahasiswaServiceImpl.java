package aryahmph.service;

import aryahmph.entity.Mahasiswa;
import aryahmph.repository.MahasiswaRepository;

import java.util.List;

public class MahasiswaServiceImpl implements MahasiswaService {

  private MahasiswaRepository mahasiswaRepository;

  public MahasiswaServiceImpl(MahasiswaRepository mahasiswaRepository) {
    this.mahasiswaRepository = mahasiswaRepository;
  }

  @Override
  public void showMahasiswa() {
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.findAll();

    System.out.println("\n== DAFTAR MAHASISWA");
    int size = mahasiswaList.size();
    for (int i = 0; i < size; i++) {
      System.out.print((i + 1) + ".\t");
      System.out.println("Nama : " + mahasiswaList.get(i).getName());
      System.out.println(" \tNIM : " + mahasiswaList.get(i).getNim());
      System.out.println(" \tEmail : " + mahasiswaList.get(i).getEmail() + "\n");
    }
  }

  @Override
  public void addMahasiswa(String name, String nim, String email) {

  }

  @Override
  public void updateMahasiswa() {

  }

  @Override
  public void deleteMahasiswa(Integer number) {

  }
}
