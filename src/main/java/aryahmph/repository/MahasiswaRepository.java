package aryahmph.repository;

import aryahmph.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
  void add(Mahasiswa mahasiswa);

  Mahasiswa findByNIM(String nim);

  List<Mahasiswa> findAll();
}
