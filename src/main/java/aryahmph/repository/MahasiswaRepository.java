package aryahmph.repository;

import aryahmph.entity.Mahasiswa;

import java.sql.SQLException;
import java.util.List;

public interface MahasiswaRepository {
  void add(Mahasiswa mahasiswa);

  Mahasiswa findByNim(String nim);

  List<Mahasiswa> findAll();
}
