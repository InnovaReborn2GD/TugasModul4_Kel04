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

    // Menu utama
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
            int pilihanMenu = scanner.nextInt();

            switch (pilihanMenu) {
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
                    throw new ArithmeticException("Pilihan tidak sah");
            }
            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan SIRAKET!");
        scanner.close();
    }

    // Function non return tanpa parameter: Menampilkan daftar film yang tersedia
    private static void filmTersedia() {
        System.out.println("Daftar Film yang Tersedia:");
        for (String film : film) {
            System.out.println("- " + film);
        }
    }

    // Function non return tanpa parameter: Menampilkan rute KA yang tersedia
    private static void ruteTersedia() {
        System.out.println("Rute Kereta Api yang Tersedia:");
        for (String rute : ruteKA) {
            System.out.println("- " + rute);
        }
    }

    // Method non return berparameter: Melakukan proses reservasi tiket bioskop
    private static void pesanTiketFilm(Scanner scanner) {
        if (kursiBioskopTersedia <= 0) {
            System.out.println("Maaf, kursi bioskop sudah penuh.");
            return; // Mencegah kode selanjutnya tereksekusi jika tiket habis
        }

        System.out.print("\nMasukkan nama Anda: ");
        scanner.nextLine(); // Consume newline
        String nama = scanner.nextLine();

        filmTersedia();
        System.out.print("Pilih film (masukkan nomor urut): ");
        int pilihanFilm = scanner.nextInt();

        if (pilihanFilm < 1 || pilihanFilm > film.length) {
            System.out.println("Pilihan film tidak valid.");
            return;
        }

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = scanner.nextInt();

        if (jumlahTiket > kursiBioskopTersedia) {
            System.out.println("Maaf, jumlah tiket melebihi kursi yang tersedia.");
            return; // Mencegah kode selanjutnya tereksekusi jika tiket habis
        }

        int totalBiaya = hitungTotalBiaya(hargaTiketFilm, jumlahTiket);
        kursiBioskopTersedia -= jumlahTiket;

        System.out.println("\nTiket berhasil dipesan! Berikut ini infomasi tiket anda:");
        System.out.println("Nama: " + nama);
        System.out.println("Film: " + film[pilihanFilm - 1]);
        System.out.println("Jumlah tiket: " + jumlahTiket);
        System.out.println("Total biaya: IDR " + totalBiaya);
    }
    
    // Method non return berparameter: Melakukan proses reservasi tiket kereta api
    private static void pesanTiketKA(Scanner scanner) {
        if (KursiKAtersedia <= 0) {
            System.out.println("Maaf, tiket kereta api sudah habis.");
            return;
        }

        System.out.print("\nMasukkan nama Anda: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        ruteTersedia();
        System.out.print("Pilih rute (masukkan nomor urut): ");
        int pilihanRute = scanner.nextInt();

        if (pilihanRute < 1 || pilihanRute > ruteKA.length) {
            System.out.println("Pilihan rute tidak valid.");
            return;
        }

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = scanner.nextInt();

        if (jumlahTiket > KursiKAtersedia) {
            System.out.println("Maaf, jumlah tiket melebihi yang tersedia.");
            return;
        }

        int totalBiaya = hitungTotalBiaya(hargaTiketKA, jumlahTiket);
        KursiKAtersedia -= jumlahTiket;

        System.out.println("\nTiket berhasil dipesan! Berikut ini infomasi tiket anda:");
        System.out.println("Nama: " + name);
        System.out.println("Rute: " + ruteKA[pilihanRute - 1]);
        System.out.println("Jumlah tiket: " + jumlahTiket);
        System.out.println("Total biaya: IDR " + totalBiaya);
    }

    // Function return type berparameter: Menghitung total biaya tiket berdasarkan jenis tiket dan jumlah yang dipesan
    private static int hitungTotalBiaya(int ticketPrice, int quantity) {
        return ticketPrice * quantity;
    }
}
