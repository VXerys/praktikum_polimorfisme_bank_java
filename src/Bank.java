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
 