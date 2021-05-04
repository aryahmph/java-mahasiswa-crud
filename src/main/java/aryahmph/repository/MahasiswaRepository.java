package aryahmph.repository;

import aryahmph.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
  void add(Mahasiswa mahasiswa);

  boolean remove(int id);

  Mahasiswa findByNim(String nim);

  Mahasiswa findById(int id);

  List<Mahasiswa> findAll();

  List<Mahasiswa> find(String value);

  boolean isExist(int id);

  boolean isNimExist(String nim);

  boolean isEmailExist(String email);

}
