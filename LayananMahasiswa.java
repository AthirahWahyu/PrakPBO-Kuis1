public class LayananMahasiswa{
    String nomorAntrian;
    String nim;
    String namaMahasiswa;
    String jenisLayanan;
    String status;

    public LayananMahasiswa(String nomorAntrian, String nim, String namaMahasiswa, String jenisLayanan) {
        this.nomorAntrian = nomorAntrian;
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.jenisLayanan = jenisLayanan;
        this.status = "MENUNGGU"; // Default status awal
    }

    // Method untuk mengubah status dari menunggu menjadi dilayani
    public void mulaiDilayani() {
        if (this.status.equals("MENUNGGU")) {
            this.status = "DILAYANI";
            System.out.println("[SUKSES] Antrian " + nomorAntrian + " (" + namaMahasiswa + ") mulai DILAYANI.");
        } else {
            System.out.println("[DITOLAK] Antrian " + nomorAntrian + " (" + namaMahasiswa + ") gagal dilayani. Status saat ini: " + this.status);
        }
    }

    // Method untuk mengubah status dari dilayani menjadi selesai
    public void selesaikanLayanan() {
        if (this.status.equals("DILAYANI")) {
            this.status = "SELESAI";
            System.out.println("[SUKSES] Antrian " + nomorAntrian + " (" + namaMahasiswa + ") telah SELESAI.");
        } else {
            System.out.println("[DITOLAK] Antrian " + nomorAntrian + " (" + namaMahasiswa + ") gagal diselesaikan. Status saat ini: " + this.status);
        }
    }

    // Method untuk mengubah status dari menunggu menjadi batal
    public void batalkanLayanan() {
        if (this.status.equals("MENUNGGU")) {
            this.status = "BATAL";
            System.out.println("[SUKSES] Antrian " + nomorAntrian + " (" + namaMahasiswa + ") berhasil DIBATALKAN.");
        } else {
            System.out.println("[DITOLAK] Pembatalan antrian " + nomorAntrian + " (" + namaMahasiswa + ") gagal. Status saat ini: " + this.status);
        }
    }

    // Method untuk menampilkan informasi antrian
    public void cetakInfo() {
        System.out.println(nomorAntrian + " | " + nim + " | " + namaMahasiswa + " | " + jenisLayanan + " | Status: " + status);
    }
}