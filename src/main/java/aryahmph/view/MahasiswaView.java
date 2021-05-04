package aryahmph.view;

import aryahmph.service.MahasiswaService;
import aryahmph.util.InputUtil;

public class MahasiswaView {
  private MahasiswaService mahasiswaService;

  public MahasiswaView(MahasiswaService mahasiswaService) {
    this.mahasiswaService = mahasiswaService;
  }

  public void showMahasiswa() {
    label:
    while (true) {
      System.out.println("\nDAFTAR MAHASISWA");
      mahasiswaService.showMahasiswa();

      System.out.println("== MENU");
      System.out.println("1. Tambah\n2. Hapus\n3. Ubah\nx. Keluar");
      String input = InputUtil.input("\nMasukkan angka");

      switch (input) {
        case "1":
          addMahasiswa();
          break;
        case "2":
          // Hapus
          break;
        case "3":
          // Ubah
          break;
        case "x":
          break label;
        default:
          System.out.println("Pilihan tidak dimengerti");
          break;
      }
    }

    System.out.println("\nTerima kasih ~");
  }

  public void addMahasiswa() {
    String name = InputUtil.input("\nMasukkan nama (x Jika Batal)");
    if (!name.equals("x")) {

      // Nim
      while (true) {
        String nim = InputUtil.input("Masukkan nim (x Jika Batal)");
        if (nim.equals("x")) {
          return;
        } else if (nim.length() > 14) {
          System.out.println("[Gagal NIM yang anda masukkan terlalu panjang]\n");
        } else if (mahasiswaService.isNimExist(nim)) {
          System.out.println("[Gagal NIM telah terdaftar]\n");
        } else {

          // Email
          while (true) {
            String email = InputUtil.input("Masukkan email (x Jika Batal)");
            if (email.equals("x")) {
              return;
            } else if (email.length() > 255) {
              System.out.println("[Gagal Email yang anda masukkan terlalu panjang]\n");
            } else if (mahasiswaService.isEmailExist(email)) {
              System.out.println("[Gagal Email telah terdaftar]\n");
            } else {

              mahasiswaService.addMahasiswa(name, nim, email);
              return;

            }
          }

        }
      }

    }
  }

}
