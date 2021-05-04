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
      System.out.println("ID : " + model.get(i).getId());
      System.out.println(" \tNama : " + model.get(i).getName());
      System.out.println(" \tNIM : " + model.get(i).getNim());
      System.out.println(" \tEmail : " + model.get(i).getEmail() + "\n");
    }
  }

  @Override
  public void addMahasiswa(String name, String nim, String email) {
    if (nim.length() > 14) {
      System.out.println("[Gagal menambahkan mahasiswa, nim terlalu panjang]");
    } else if (name.length() > 255) {
      System.out.println("[Gagal menambahkan mahasiswa, nama terlalu panjang]");
    } else if (email.length() > 255) {
      System.out.println("[Gagal menambahkan mahasiswa, email terlalu panjang]");
    } else {
      mahasiswaRepository.add(new Mahasiswa(name, nim, email));
      System.out.println("[Sukses menambahkan mahasiswa : " + name + " ]");
    }
  }

  @Override
  public void updateMahasiswa() {

  }

  @Override
  public void removeMahasiswa(int number) {
    boolean isSuccess = mahasiswaRepository.remove(number);
    if (isSuccess) {
      System.out.println("[Berhasil menghapus mahasiswa kode : " + number + " ]");
    } else {
      System.out.println("[Gagal menghapus mahasiswa kode : " + number + " ]");
    }
  }

  @Override
  public Mahasiswa findById(int id) {
    return mahasiswaRepository.findById(id);
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
