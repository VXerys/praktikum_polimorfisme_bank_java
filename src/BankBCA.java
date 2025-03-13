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
 