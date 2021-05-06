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
    displayPropertyMahasiswa(model);
  }

  @Override
  public void addMahasiswa(String name, String nim, String email) {
    mahasiswaRepository.add(new Mahasiswa(name, nim, email));
    System.out.println("[Sukses menambahkan mahasiswa : " + name + " ]");

  }

  @Override
  public void updateMahasiswa(int id, String name, String nim, String email) {
    if (nim.length() > 14) {
      System.out.println("[Gagal nim terlalu panjang, maks 14]");
    } else if (email.length() > 255) {
      System.out.println("[Gagal email terlalu panjang, maks 255]");
    } else if (name.length() > 255) {
      System.out.println("[Gagal nama terlalu panjang, maks 255]");
    }

    Mahasiswa mahasiswa = mahasiswaRepository.findById(id);

    if (!nim.equals(mahasiswa.getNim()) && isNimExist(nim)) {
      System.out.println("[Gagal mengubah, nim telah terdaftar]");
      return;
    }

    if (!email.equals(mahasiswa.getNim()) && isEmailExist(email)) {
      System.out.println("[Gagal mengubah, nim telah terdaftar]");
      return;
    }

    boolean isSuccess = mahasiswaRepository.update(new Mahasiswa(id, name, nim, email));
    if (isSuccess)
      System.out.println("[Berhasil mengubah mahasiswa kode : " + id + " ]");
    else
      System.out.println("[Gagal mengubah mahasiswa kode : " + id + " ]");

  }

  @Override
  public void removeMahasiswa(int number) {
    boolean isSuccess = mahasiswaRepository.remove(number);
    if (isSuccess)
      System.out.println("[Berhasil menghapus mahasiswa kode : " + number + " ]");
    else
      System.out.println("[Gagal menghapus mahasiswa kode : " + number + " ]");

  }

  @Override
  public Mahasiswa findById(int id) {
    return mahasiswaRepository.findById(id);
  }

  @Override
  public void searchMahasiswa(String value) {
    List<Mahasiswa> model = mahasiswaRepository.find(value);
    if (model == null) {
      System.out.println("\nData tidak ditemukan");
    } else {
      displayPropertyMahasiswa(model);
    }
  }

  private void displayPropertyMahasiswa(List<Mahasiswa> model) {
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
  public boolean isNimExist(String nim) {
    return mahasiswaRepository.isNimExist(nim);
  }

  @Override
  public boolean isEmailExist(String email) {
    return mahasiswaRepository.isEmailExist(email);
  }
}
