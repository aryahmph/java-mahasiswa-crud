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
    String name = InputUtil.input("\nMasukkan nama");
    String nim, email = "";

    while (true) {
      nim = InputUtil.input("Masukkan nim");
      if (nim.equals("x")) {
        break;
      } else if (nim.length() < 14 && !mahasiswaService.isNimExist(nim)) {
        break;
      }

      if (nim.length() > 14) {
        System.out.println("[ERROR] NIM terlalu panjang!");
      } else {
        System.out.println("[ERROR] NIM sudah terdaftar!");
      }

      System.out.println("Silahkan masukkan kembali NIM anda. (x. Keluar)\n");

    }

    while (!nim.equals("x")) {
      email = InputUtil.input("Masukkan email");
      if (email.equals("x")) {
        break;
      } else if (!mahasiswaService.isEmailExist(email)) {
        break;
      } else {
        System.out.println("[ERROR] Email sudah terdaftar!");
        System.out.println("Silahkan masukkan kembali Email anda. (x. Keluar)\n");
      }
    }

    if (!nim.equals("x") && !email.equals("x")) {
      mahasiswaService.addMahasiswa(name, nim, email);
      System.out.println("\n[SUCCESS] Berhasil menambahkan data!");
    }
  }

}
