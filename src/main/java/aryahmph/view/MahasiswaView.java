package aryahmph.view;

import aryahmph.entity.Mahasiswa;
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
      System.out.println("1. Tambah\n2. Hapus\n3. Cari\n4. Ubah\nx. Keluar");
      String input = InputUtil.input("\nMasukkan angka");

      switch (input) {
        case "1":
          addMahasiswa();
          break;
        case "2":
          removeMahasiswa();
          break;
        case "3":
          searchMahasiswa();
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

  public void removeMahasiswa() {
    try {
      String id = InputUtil.input("Masukkan ID (x Jika Batal)");
      if (!id.equals("x")) {
        Mahasiswa mahasiswa = mahasiswaService.findById(Integer.parseInt(id));

        if (mahasiswa == null) {
          System.out.println("[Gagal ID salah, data tidak ditemukan]");
          return;
        }

        System.out.println("\nNama :\t" + mahasiswa.getName());
        System.out.println("NIM :\t" + mahasiswa.getNim());
        System.out.println("Email :\t" + mahasiswa.getEmail());

        String isSure = InputUtil.input("\nAnda yakin ingin menghapus data tersebut ? (Y/n)");
        if (isSure.equalsIgnoreCase("y")) {
          mahasiswaService.removeMahasiswa(Integer.parseInt(id));
          System.out.println("[Berhasil menghapus mahasiswa : " + mahasiswa.getName() + " ]");
        } else if (isSure.equalsIgnoreCase("n")) {
          System.out.println("[Batal menghapus data]");
        } else {
          System.out.println("Pilihan tidak dimengerti");
        }
      }
    } catch (NumberFormatException exception) {
      System.out.println("Input salah!");
    }

  }

  public void searchMahasiswa() {
    label:
    while (true) {
      String key = InputUtil.input("\nMasukkan kata kunci (x Jika Batal)");
      if (key.equals("x")) break;
      else mahasiswaService.searchMahasiswa(key);


      while (true) {
        System.out.println("== MENU");
        System.out.println("1. Hapus\n2. Ubah\nx. Keluar");
        String input = InputUtil.input("\nMasukkan angka");

        switch (input) {
          case "1":
            removeMahasiswa();
            break;
          case "2":
            //ubah
          case "x":
            break label;
          default:
            System.out.println("Pilihan tidak dimengerti");
            break;
        }
      }


    }

  }

}
