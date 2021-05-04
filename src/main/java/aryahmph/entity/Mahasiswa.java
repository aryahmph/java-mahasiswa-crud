package aryahmph.entity;

public class Mahasiswa {
  private int id;
  private String name;
  private String nim;
  private String email;

  public Mahasiswa(int id, String name, String nim, String email) {
    this.id = id;
    this.name = name;
    this.nim = nim;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNim() {
    return nim;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Mahasiswa{" +
      "name='" + name + '\'' +
      ", nim='" + nim + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
