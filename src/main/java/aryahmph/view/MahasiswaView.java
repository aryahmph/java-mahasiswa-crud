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

    System.out.println("Terima kasih~");
  }

  public void addMahasiswa() {
    String name = InputUtil.input("Masukkan nama");
    String nim, email = "";

    while (true) {
      nim = InputUtil.input("Masukkan nim");
      if (nim.equals("x")) {
        break;
      } else if (!mahasiswaService.isNimExist(nim)) {
        break;
      } else {
        System.out.println("[ERROR] NIM sudah terdaftar!");
        System.out.println("Silahkan masukkan kembali NIM anda. (x. Keluar)");
      }
    }

    while (!nim.equals("x")) {
      email = InputUtil.input("Masukkan email");
      if (email.equals("x")) {
        break;
      } else if (!mahasiswaService.isEmailExist(email)) {
        break;
      } else {
        System.out.println("[ERROR] Email sudah terdaftar!");
        System.out.println("Silahkan masukkan kembali Email anda. (x. Keluar)");
      }
    }

    if (!nim.equals("x") && !email.equals("x")) {
      mahasiswaService.addMahasiswa(name, nim, email);
      System.out.println("[SUCCESS] Berhasil menambahkan data!");
    }
  }

}
