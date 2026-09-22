public class PaketInternet {
    
    String kodePaket;
    String namaPaket;
    int kuota;          // Dalam satuan MB
    int harga;          // Dalam satuan Rupiah
    boolean statusAktif; // true = AKTIF, false = NONAKTIF

    // Objek baru selalu dalam keadaan NONAKTIF
    public PaketInternet(String kodePaket, String namaPaket, int kuotaAwal, int harga) {
        this.kodePaket = kodePaket;
        this.namaPaket = namaPaket;
        this.statusAktif = false; // Keadaan awal wajib NONAKTIF

        // Validasi kuota awal harus lebih dari 0
        if (kuotaAwal > 0) {
            this.kuota = kuotaAwal;
        } else {
            System.out.println("[PERINGATAN] Kuota awal harus lebih dari 0! Kuota diset default ke 1000 MB.");
            this.kuota = 1000;
        }

        // Validasi harga tidak boleh negatif
        if (harga >= 0) {
            this.harga = harga;
        } else {
            System.out.println("[PERINGATAN] Harga tidak boleh negatif! Harga diset default ke Rp 0.");
            this.harga = 0;
        }
    }

    // Method untuk mengaktifkan paket
    public void aktifkanPaket() {
        this.statusAktif = true;
        System.out.println("[SUKSES] Paket " + kodePaket + " (" + namaPaket + ") berhasil DIAKTIFKAN.");
    }

    // Method untuk menonaktifkan paket
    public void nonaktifkanPaket() {
        this.statusAktif = false;
        System.out.println("[SUKSES] Paket " + kodePaket + " (" + namaPaket + ") telah DINONAKTIFKAN.");
    }

    // Method untuk menggunakan kuota internet
    public void gunakanKuota(int jumlahPenggunaan) {
        // Memeriksa apakah paket sudah aktif
        if (!this.statusAktif) {
            System.out.println("[DITOLAK] Penggunaan gagal. Paket " + kodePaket + " (" + namaPaket + ") dalam keadaan NONAKTIF.");
            return;
        }

        // Memeriksa apakah nilai penggunaan bernilai positif atau lebih dari 0
        if (jumlahPenggunaan <= 0) {
            System.out.println("[DITOLAK] Penggunaan gagal. Jumlah penggunaan kuota harus lebih dari 0 MB.");
            return;
        }

        // Memeriksa apakah penggunaan melebihi sisa kuota yang tersisa
        if (jumlahPenggunaan > this.kuota) {
            System.out.println("[DITOLAK] Penggunaan " + jumlahPenggunaan + " MB ditolak! Kuota tersisa hanya " + this.kuota + " MB.");
            return;
        }

        // Jika semua validasi berhasil, kuota berkurang
        this.kuota -= jumlahPenggunaan;
        System.out.println("[SUKSES] Berhasil menggunakan " + jumlahPenggunaan + " MB. Sisa kuota Paket " + kodePaket + ": " + this.kuota + " MB.");
    }

    // Method untuk menampilkan sisa kuota dan status paket
    public void tampilkanStatus() {
        String statusStr = statusAktif ? "AKTIF" : "NONAKTIF";
        System.out.println("Kode: " + kodePaket + " | Nama: " + namaPaket + " | Harga: Rp " + harga + " | Sisa Kuota: " + kuota + " MB | Status: " + statusStr);
    }
}