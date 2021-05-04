package aryahmph.service;

public interface MahasiswaService {
  void showMahasiswa();

  void addMahasiswa(String name, String nim, String email);

  void updateMahasiswa();

  void removeMahasiswa(int number);

  boolean isNimExist(String nim);

  boolean isEmailExist(String email);
}
