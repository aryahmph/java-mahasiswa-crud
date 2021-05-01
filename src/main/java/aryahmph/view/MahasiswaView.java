package aryahmph.view;

import aryahmph.service.MahasiswaService;
import aryahmph.util.InputUtil;

public class MahasiswaView {
  private MahasiswaService mahasiswaService;

  public MahasiswaView(MahasiswaService mahasiswaService) {
    this.mahasiswaService = mahasiswaService;
  }

  public void showMahasiswa() {
    while (true) {
      System.out.println("\nDAFTAR MAHASISWA");
      mahasiswaService.showMahasiswa();

      System.out.println("== MENU");
      System.out.println("1. Tambah\n2. Hapus\n3. Ubah\nx. Keluar");
      String input = InputUtil.input("Masukkan angka");

      if (input.equals("1")) {
        addMahasiswa();
      } else if (input.equals("2")) {

      } else if (input.equals("3")) {

      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan tidak dimengerti");
      }

    }
  }

  public void addMahasiswa() {
    String name = InputUtil.input("Masukkan nama : ");
    String nim = InputUtil.input("Masukkan nim : ");
    String email = InputUtil.input("Masukkan nama : ");
    mahasiswaService.addMahasiswa(name, nim, email);
  }

}
