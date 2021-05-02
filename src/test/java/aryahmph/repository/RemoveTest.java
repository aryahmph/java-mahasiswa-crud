package aryahmph.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveTest {

  @Test
  void testRemove() {
    MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
    boolean deleted = mahasiswaRepository.remove("203031");
    Assertions.assertEquals(true, deleted);
  }
}
