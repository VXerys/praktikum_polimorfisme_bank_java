import java.util.Scanner;

public class BankApp {
    @SuppressWarnings({"unused", "ConvertToTryWithResources"})
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
            scanner.nextLine(); 

            Bank bank;
            int jumlah;
            String rekTujuan;
            String bankTujuan = ""; 
            String berita = "";

            switch (pilihanBank) {
                case 1 ->  {
                    bank = new Bank();
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    System.out.print("Apakah transfer antar bank? (y/n): ");
                    String transferInput = scanner.nextLine();
                    if (transferInput.equalsIgnoreCase("y")) {
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
                }
                case 2 ->  {
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    bank = new BankBCA(jumlah, rekTujuan);
                    bank.transferUang(jumlah, rekTujuan, "BCA");
                }
                case 3 ->  {
                    System.out.print("Masukkan jumlah transfer: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan rekening tujuan: ");
                    rekTujuan = scanner.nextLine();
                    bank = new BankBNI(jumlah, rekTujuan);
                    bank.transferUang(jumlah, rekTujuan, "BNI");
                }
                default -> {
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

            double total = bank.totalJumlahDenganBunga(0); 
            System.out.println("Total jumlah dengan bunga: " + total);
            
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
