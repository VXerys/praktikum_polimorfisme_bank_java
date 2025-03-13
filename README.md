# Aplikasi Transaksi Bank Sederhana (Java OOP) 💰

Dokumentasi ini menjelaskan proyek **Aplikasi Transaksi Bank Sederhana** yang dibuat menggunakan konsep Java Object-Oriented Programming (OOP). Proyek ini mengimplementasikan method overloading dan overriding untuk menangani berbagai jenis transaksi perbankan, serta perhitungan bunga.

---

## Daftar Isi

- [Aplikasi Transaksi Bank Sederhana (Java OOP) 💰](#aplikasi-transaksi-bank-sederhana-java-oop-)
  - [Daftar Isi](#daftar-isi)
  - [Ikhtisar Proyek](#ikhtisar-proyek)
  - [Struktur Kode](#struktur-kode)
    - [1. Bank.java](#1-bankjava)
    - [2. BankBCA.java](#2-bankbcajava)
    - [3. BankBNI.java](#3-bankbnijava)
    - [4. BankApp.java (Main Class)](#4-bankappjava-main-class)
  - [Cara Kompilasi \& Jalankan](#cara-kompilasi--jalankan)
  - [Contoh Skenario Penggunaan](#contoh-skenario-penggunaan)
    - [Skenario 1: Bank Standar (tanpa transfer antar bank)](#skenario-1-bank-standar-tanpa-transfer-antar-bank)
    - [Skenario 2: Bank BCA](#skenario-2-bank-bca)
    - [Skenario 3: Bank BNI](#skenario-3-bank-bni)
  - [Penjelasan Konsep Kunci](#penjelasan-konsep-kunci)
  - [Referensi](#referensi)

---

## Ikhtisar Proyek

Proyek ini merupakan aplikasi sederhana untuk menangani transaksi perbankan dengan fitur:
- **Method Overloading:** Metode `transferUang()` pada kelas **Bank** memiliki tiga versi dengan parameter berbeda, yang memungkinkan transaksi dengan atau tanpa berita, serta untuk transfer antar bank.
- **Method Overriding:** Kelas **BankBCA** dan **BankBNI** mewarisi dari **Bank** dan mengoverride metode tertentu (seperti `transferUang()`, `sukuBunga()`, dan `totalJumlahDenganBunga()`) agar secara otomatis menetapkan bank tujuan dan suku bunga khusus.
- **Perhitungan Bunga:** Metode `sukuBunga()` mencetak informasi bunga, sedangkan `totalJumlahDenganBunga(double)` menghitung total jumlah dengan bunga (misalnya, untuk bank standar bunga 3% diterapkan jika bukan transfer antar bank).
- **Interaksi Pengguna:** Kelas **BankApp** merupakan kelas utama yang menerima input menggunakan `Scanner` dengan blok try-catch dan switch-case, sehingga pengguna dapat memilih jenis bank dan melakukan transaksi sesuai dengan instruksi.

---

## Struktur Kode

### 1. Bank.java

Kelas **Bank** merupakan kelas dasar yang memiliki atribut:
- `jumlah`
- `rekeningTujuan`
- `bankTujuan`
- `berita`

Metode utama:
- **transferUang(...):** Terdapat tiga versi metode untuk menangani transfer ke rekening lain (dengan atau tanpa bank dan berita).
- **sukuBunga():** Mencetak pesan suku bunga standar 3%.
- **totalJumlahDenganBunga(double):** Menghitung total jumlah setelah ditambahkan bunga.
- **infoTransfer():** Menampilkan informasi transaksi.

```java
public class Bank {
    int jumlah;
    String rekeningTujuan;
    String bankTujuan;
    String berita;

    public void transferUang(int jumlah, String rekeningTujuan) {
         this.jumlah = jumlah;
         this.rekeningTujuan = rekeningTujuan;
         System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan);
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
         this.jumlah = jumlah;
         this.bankTujuan = bankTujuan;
         this.rekeningTujuan = rekeningTujuan;
         System.out.println("Transfer " + jumlah + " ke bank " + bankTujuan + " rekening " + rekeningTujuan);
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
         this.jumlah = jumlah;
         this.bankTujuan = bankTujuan;
         this.rekeningTujuan = rekeningTujuan;
         this.berita = berita;
         System.out.println("Transfer " + jumlah + " ke bank " + bankTujuan 
              + " rekening " + rekeningTujuan + " dengan berita: " + berita);
    }

    public void sukuBunga() {
         System.out.println("Suku Bunga standar adalah 3%");
    }

    public double totalJumlahDenganBunga(double sukuBunga) {
         return jumlah * (1 + sukuBunga);
    }

    public void infoTransfer() {
         System.out.println("Transfer Uang");
         System.out.println("Jumlah : " + jumlah);
         System.out.println("Rekening Tujuan : " + rekeningTujuan);
         System.out.println("Bank Tujuan : " + bankTujuan);
         System.out.println("Berita : " + berita);
    }
}
```

---

### 2. BankBCA.java

Kelas **BankBCA** merupakan subclass dari **Bank** yang mengoverride beberapa metode:
- Secara otomatis menetapkan bank tujuan ke "BCA".
- Menetapkan suku bunga 4.5% melalui `totalJumlahDenganBunga()`.
- Overriding `sukuBunga()` untuk mencetak informasi khusus Bank BCA.

```java
public class BankBCA extends Bank {
    double sukuBungaBCA = 0.045; // 4.5%

    public BankBCA(int jumlah, String rekeningTujuan) {
         this.jumlah = jumlah;
         this.rekeningTujuan = rekeningTujuan;
         this.bankTujuan = "BCA";
    }
    
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
         this.jumlah = jumlah;
         this.rekeningTujuan = rekeningTujuan;
         this.bankTujuan = "BCA";
         System.out.println("Transfer " + jumlah + " ke bank " + this.bankTujuan + " rekening " + rekeningTujuan);
    }
    
    @Override
    public double totalJumlahDenganBunga(double dummy) {
         return jumlah * (1 + sukuBungaBCA);
    }
    
    @Override
    public void sukuBunga() {
         System.out.println("Suku Bunga dari Bank BCA adalah 4.5%");
    }
    
    @Override
    public void infoTransfer() {
         super.infoTransfer();
         System.out.println("Suku Bunga Bank BCA: " + (sukuBungaBCA * 100) + "%");
    }
}
```

---

### 3. BankBNI.java

Kelas **BankBNI** juga merupakan subclass dari **Bank** dengan penyesuaian:
- Menetapkan bank tujuan ke "BNI".
- Suku bunga khusus 4% digunakan dalam perhitungan total.
- Overriding `transferUang()`, `sukuBunga()`, dan `infoTransfer()` agar sesuai dengan ketentuan Bank BNI.

```java
public class BankBNI extends Bank {
    double sukuBungaBNI = 0.04; // 4%

    public BankBNI(int jumlah, String rekeningTujuan) {
         this.jumlah = jumlah;
         this.rekeningTujuan = rekeningTujuan;
         this.bankTujuan = "BNI";
    }
    
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
         this.jumlah = jumlah;
         this.rekeningTujuan = rekeningTujuan;
         this.bankTujuan = "BNI";
         System.out.println("Transfer " + jumlah + " ke bank " + this.bankTujuan + " rekening " + rekeningTujuan);
    }
    
    @Override
    public double totalJumlahDenganBunga(double dummy) {
         return jumlah * (1 + sukuBungaBNI);
    }
    
    @Override
    public void sukuBunga() {
         System.out.println("Suku Bunga dari Bank BNI adalah 4%");
    }
    
    @Override
    public void infoTransfer() {
         super.infoTransfer();
         System.out.println("Suku Bunga Bank BNI: " + (sukuBungaBNI * 100) + "%");
    }
}
```

---

### 4. BankApp.java (Main Class)

Kelas **BankApp** adalah titik masuk aplikasi yang menggunakan `Scanner` untuk menerima input dari pengguna. Kode ini sudah disusun dengan blok try-catch dan switch-case untuk menghindari error null serta menangani semua opsi input sesuai dengan perintah tugas.

```java
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== Selamat Datang di Aplikasi Transaksi Bank ===");
            System.out.println("Pilih jenis bank tujuan transfer:");
            System.out.println("1. Bank (standar)");
            System.out.println("2. Bank BCA");
            System.out.println("3. Bank BNI");
            System.out.print("Masukkan pilihan (1-3): ");
            int pilihanBank = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            Bank bank;
            int jumlah;
            String rekTujuan;
            String bankTujuan = ""; // diinisialisasi agar tidak null
            String berita = "";
            boolean transferFlag = false;
            
            switch (pilihanBank) {
                case 1: {
                    bank = new Bank();
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    System.out.print("Apakah transfer antar bank? (y/n): ");
                    String transferInput = scanner.nextLine();
                    transferFlag = transferInput.equalsIgnoreCase("y");
                    if (transferFlag) {
                        System.out.print("Masukkan nama bank tujuan: ");
                        bankTujuan = scanner.nextLine();
                        System.out.print("Apakah ada berita tambahan? (y/n): ");
                        String beritaInput = scanner.nextLine();
                        if (beritaInput.equalsIgnoreCase("y")) {
                            System.out.print("Masukkan berita: ");
                            berita = scanner.nextLine();
                            bank.transferUang(jumlah, rekTujuan, bankTujuan, berita);
                        } else {
                            bank.transferUang(jumlah, rekTujuan, bankTujuan);
                        }
                    } else {
                        bank.transferUang(jumlah, rekTujuan);
                    }
                    break;
                }
                case 2: {
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    bank = new BankBCA(jumlah, rekTujuan);
                    bank.transferUang(jumlah, rekTujuan, "BCA");
                    break;
                }
                case 3: {
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    bank = new BankBNI(jumlah, rekTujuan);
                    bank.transferUang(jumlah, rekTujuan, "BNI");
                    break;
                }
                default: {
                    System.out.println("Pilihan bank tidak valid.");
                    scanner.close();
                    return;
                }
            }

            if (bank == null) {
                System.out.println("Bank tidak diinisialisasi. Program dihentikan.");
                scanner.close();
                return;
            }

            System.out.println("\n=== Informasi Transfer ===");
            bank.infoTransfer();

            bank.sukuBunga();

            // Jika bank standar dan transfer antar bank tidak dipilih, terapkan bunga 3%
            double total;
            if (pilihanBank == 1 && !transferFlag) {
                total = bank.totalJumlahDenganBunga(0.03);
            } else {
                total = bank.totalJumlahDenganBunga(0);
            }
            System.out.println("Total jumlah dengan bunga: " + total);
            
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
```

---

## Cara Kompilasi & Jalankan

1. Pastikan semua file (.java) berada dalam satu direktori.
2. Buka terminal atau command prompt di direktori proyek.
3. Kompilasi seluruh file:
   ```bash
   javac Bank.java BankBCA.java BankBNI.java BankApp.java
   ```
4. Jalankan aplikasi:
   ```bash
   java BankApp
   ```

---

## Contoh Skenario Penggunaan

### Skenario 1: Bank Standar (tanpa transfer antar bank)
- **Input:**
  - Pilihan: 1  
  - Jumlah Transfer: 500  
  - Rekening Tujuan: 987654321  
  - Transfer antar bank? (y/n): n  
- **Output yang Diharapkan:**
  ```
  Transfer 500 ke rekening 987654321

  === Informasi Transfer ===
  Transfer Uang
  Jumlah : 500
  Rekening Tujuan : 987654321
  Bank Tujuan : null
  Berita : null

  Suku Bunga standar adalah 3%
  Total jumlah dengan bunga: 515.0
  ```

### Skenario 2: Bank BCA
- **Input:**
  - Pilihan: 2  
  - Jumlah Transfer: 75000  
  - Rekening Tujuan: 1122334455  
- **Output yang Diharapkan:**
  ```
  Transfer 75000 ke bank BCA rekening 1122334455

  === Informasi Transfer ===
  Transfer Uang
  Jumlah : 75000
  Rekening Tujuan : 1122334455
  Bank Tujuan : BCA
  Berita : null

  Suku Bunga dari Bank BCA adalah 4.5%
  Suku Bunga Bank BCA: 4.5%
  Total jumlah dengan bunga: 78375.0
  ```

### Skenario 3: Bank BNI
- **Input:**
  - Pilihan: 3  
  - Jumlah Transfer: 60000  
  - Rekening Tujuan: 9988776655  
- **Output yang Diharapkan:**
  ```
  Transfer 60000 ke bank BNI rekening 9988776655

  === Informasi Transfer ===
  Transfer Uang
  Jumlah : 60000
  Rekening Tujuan : 9988776655
  Bank Tujuan : BNI
  Berita : null

  Suku Bunga dari Bank BNI adalah 4%
  Suku Bunga Bank BNI: 4.0%
  Total jumlah dengan bunga: 62400.0
  ```

---

## Penjelasan Konsep Kunci

- **Method Overloading:**  
  Metode `transferUang()` di kelas **Bank** memiliki tiga versi, yang memungkinkan transaksi dengan parameter berbeda (misalnya, dengan atau tanpa berita, atau transfer antar bank).

- **Method Overriding:**  
  Kelas **BankBCA** dan **BankBNI** mengoverride metode `transferUang()`, `sukuBunga()`, dan `totalJumlahDenganBunga()` untuk menetapkan nilai bank tujuan dan suku bunga yang sesuai.

- **Perhitungan Bunga:**  
  Pada bank standar, jika transfer antar bank tidak dilakukan, bunga 3% diterapkan melalui pemanggilan `totalJumlahDenganBunga(0.03)`. Sedangkan untuk BankBCA dan BankBNI, metode overriding menerapkan suku bunga khusus.

- **Input & Validasi:**  
  Kelas **BankApp** menggunakan `Scanner` untuk menerima input, dilengkapi dengan blok try-catch dan switch-case untuk menangani berbagai opsi transaksi.

---

## Referensi

- [Dokumentasi Java Oracle](https://docs.oracle.com/javase/)
- [Tutorial Java OOP](https://www.javatpoint.com/java-oops)
- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
