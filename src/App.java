public class App {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();

          bank.transferUang(100000, "1234567890");
          bank.infoTransfer();
          System.out.println("-------------------------------");
          
          bank.transferUang(200000, "BankBCA", "0987654321");
          bank.infoTransfer();
          System.out.println("-------------------------------");
          
          bank.transferUang(300000, "BankBNI", "1122334455", "Pembayaran Tagihan Listrik");
          bank.infoTransfer();
          System.out.println("-------------------------------");
          
          bank.sukuBunga();
          
          double total = bank.totalJumlahDenganBunga(0.03);
          System.out.println("Total jumlah dengan suku bunga 3%: " + total);
    }
}
