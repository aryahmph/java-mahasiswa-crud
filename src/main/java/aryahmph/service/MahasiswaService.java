package aryahmph.service;

import aryahmph.entity.Mahasiswa;

public interface MahasiswaService {
  void showMahasiswa();

  void addMahasiswa(String name, String nim, String email);

  void updateMahasiswa();

  void removeMahasiswa(int number);

  Mahasiswa findById(int id);

  boolean isNimExist(String nim);

  boolean isEmailExist(String email);
}
