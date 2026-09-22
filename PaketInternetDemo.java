public class PaketInternetDemo {
    public static void main(String[] args) {
        System.out.println("================================================================");
        System.out.println("                SISTEM PAKET INTERNET MAHASISWA                ");
        System.out.println("=================================================================\n");

        // Membuat 3 objek paket internet
        PaketInternet pkt1 = new PaketInternet("PKT-01", "Paket Daily 5GB", 5000, 10000); // Objek 1
        PaketInternet pkt2 = new PaketInternet("PKT-02", "Paket Weekly 10GB", 10000, 25000); // Objek 2
        PaketInternet pkt3 = new PaketInternet("PKT-03", "Paket Hemat 2GB", 2000, 5000); // Objek 3

        System.out.println("--- 1. UJI PENGGUNAAN SAAT STATUS NONAKTIF (Paket 1) ---");
        pkt1.tampilkanStatus(); // Status awal NONAKTIF
        pkt1.gunakanKuota(500); // DITOLAK: Karena belum diaktifkan
        System.out.println();

        System.out.println("--- 2. UJI AKTIVASI DAN PENGGUNAAN VALID (Paket 1) ---");
        pkt1.aktifkanPaket();   // Mengaktifkan paket
        pkt1.gunakanKuota(1500); // SUKSES: Sisa kuota menjadi 3500 MB
        pkt1.gunakanKuota(1000); // SUKSES: Sisa kuota menjadi 2500 MB
        System.out.println();

        System.out.println("--- 3. UJI PENGGUNAAN MELEBIHI KUOTA TERSISA (Paket 2) ---");
        pkt2.aktifkanPaket();
        pkt2.gunakanKuota(12000); // DITOLAK: Penggunaan 12000 MB melebihi kuota (10000 MB)
        pkt2.gunakanKuota(4000);  // SUKSES: Penggunaan valid (sisa 6000 MB)
        System.out.println();

        System.out.println("--- 4. UJI JUMLAH TIDAK VALID & NONAKTIVASI PAKET (Paket 3) ---");
        pkt3.aktifkanPaket();
        pkt3.gunakanKuota(-500);  // DITOLAK: Karena umlah kuota harus positif atau lebih dari 0
        pkt3.gunakanKuota(500);   // SUKSES: Kuota tersisa 1500 MB
        pkt3.nonaktifkanPaket();  // Menonaktifkan paket
        pkt3.gunakanKuota(200);   // DITOLAK: Karena pket sudah DINONAKTIFKAN kembali
        System.out.println();

        System.out.println("=========================================================================");
        System.out.println("                      STATUS AKHIR SELURUH PAKET INTERNET                     ");
        System.out.println("=========================================================================");
        pkt1.tampilkanStatus();
        pkt2.tampilkanStatus();
        pkt3.tampilkanStatus();
        System.out.println("=========================================================================");
    }
}