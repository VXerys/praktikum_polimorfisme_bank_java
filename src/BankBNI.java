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
 