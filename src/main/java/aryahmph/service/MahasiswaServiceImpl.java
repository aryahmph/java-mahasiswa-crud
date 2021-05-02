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
    List<Mahasiswa> model = mahasiswaRepository.findAll();
    int size = model.size();
    for (int i = 0; i < size; i++) {
      System.out.print((i + 1) + ".\t");
      System.out.println("Nama : " + model.get(i).getName());
      System.out.println(" \tNIM : " + model.get(i).getNim());
      System.out.println(" \tEmail : " + model.get(i).getEmail() + "\n");
    }
  }

  @Override
  public void addMahasiswa(String name, String nim, String email) {
    mahasiswaRepository.add(new Mahasiswa(name, nim, email));
  }

  @Override
  public void updateMahasiswa() {

  }

  @Override
  public void deleteMahasiswa(Integer number) {
//    String nim = model.get(number - 1).getNim(number - 1);
  }

  @Override
  public boolean isNimExist(String nim) {
    return mahasiswaRepository.isNimExist(nim);
  }

  @Override
  public boolean isEmailExist(String email) {
    return mahasiswaRepository.isEmailExist(email);
  }
}
