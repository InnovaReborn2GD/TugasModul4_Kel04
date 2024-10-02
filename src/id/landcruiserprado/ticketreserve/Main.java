package id.landcruiserprado.ticketreserve;
import java.util.Scanner;

public class Main {
    // Daftar film atau rute yang tersedia
    private static String[] film = {"Trasformers One", "Inside Out 2", "Despicable Me 2", "Deadpool & Wolverine"};
    private static String[] ruteKA = {"Semarang - Jakarta", "Semarang - Jogja", "Semarang - Surabaya"};

    // Harga tiket per jenis dan rute
    private static int hargaTiketFilm = 20000;
    private static int hargaTiketKA = 120000;

    // Jumlah kursi/tiket yang tersedia
    private static int kursiBioskopTersedia = 40;
    private static int KursiKAtersedia = 110;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjutPesan = true;

        while (lanjutPesan) {
            System.out.println("Selamat Datang di SIRAKET (Sistem Reservasi Tiket) v1.00");
            System.out.println("1. Daftar film yang tersedia");
            System.out.println("2. Rute kereta api yang tersedia");
            System.out.println("3. Pesan tiket bioskop");
            System.out.println("4. Pesan tiket kereta api");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    filmTersedia();
                    break;
                case 2:
                    ruteTersedia();
                    break;
                case 3:
                    pesanTiketFilm(scanner);
                    break;
                case 4:
                    pesanTiketKA(scanner);
                    break;
                case 5:
                    lanjutPesan = false;
                    break;
                default:
                    System.out.println("Pilihan yang anda masukkan tidak sah, silakan coba lagi");
            }
            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan SIRAKET!");
        scanner.close();
    }
}