package aryahmph.repository;

import aryahmph.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
  void add(Mahasiswa mahasiswa);

  boolean remove(int id);

  boolean isExist(int id);

  Mahasiswa findByNim(String nim);

  List<Mahasiswa> findAll();

  boolean isNimExist(String nim);

  boolean isEmailExist(String email);

}
