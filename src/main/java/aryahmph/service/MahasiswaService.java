package aryahmph.service;

public interface MahasiswaService {
  void showMahasiswa();

  void addMahasiswa(int id, String name, String nim, String email);

  void updateMahasiswa();

  void deleteMahasiswa(Integer number);

  boolean isNimExist(String nim);

  boolean isEmailExist(String email);
}
