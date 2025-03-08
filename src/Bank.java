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

     public void transferUang(int jumlah, String bankTujuan, String rekeningTujuan) {
          this.jumlah = jumlah;
          this.bankTujuan = bankTujuan;
          this.rekeningTujuan = rekeningTujuan;
          System.out.println("Transfer " + jumlah + " ke bank " + bankTujuan + " rekening " + rekeningTujuan);
     }

     public void transferUang(int jumlah, String bankTujuan, String rekeningTujuan, String berita) {
          this.jumlah = jumlah;
          this.bankTujuan = bankTujuan;
          this.rekeningTujuan = rekeningTujuan;
          this.berita = berita;
          System.out.println("Transfer " + jumlah + " ke bank " + bankTujuan 
               + " rekening " + rekeningTujuan + " dengan berita: " + berita);
     }

     public int getJumlah() {
          return jumlah;
     }

     public void setJumlah(int jumlah) {
          this.jumlah = jumlah;
     }

     public String getRekeningTujuan() {
          return rekeningTujuan;
     }

     public void setRekeningTujuan(String rekeningTujuan) {
          this.rekeningTujuan = rekeningTujuan;
     }

     public String getBankTujuan() {
          return bankTujuan;
     }

     public void setBankTujuan(String bankTujuan) {
          this.bankTujuan = bankTujuan;
     }

     public String getBerita() {
          return berita;
     }

     public void setBerita(String berita) {
          this.berita = berita;
     }

     public void sukuBunga() {
          System.out.println("Suku Bunga standar adalah 3%");
      }
      
      public double totalJumlahDenganBunga(double sukuBunga) {
          return jumlah * (1 + sukuBunga);
     }
     
      public void infoTransfer(){
          System.out.println("Transfer Uang");
          System.out.println("Jumlah : " + getJumlah());
          System.out.println("Rekening Tujuan : " + getRekeningTujuan());
          System.out.println("Bank Tujuan : " + getBankTujuan());
          System.out.println("Berita : " + getBerita());

      }
}
