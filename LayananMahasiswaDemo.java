public class LayananMahasiswaDemo {
    public static void main(String[] args) {
        System.out.println("--- PENGUJIAN SISTEM ANTRIAN LAYANAN AKADEMIK ---\n");

        // Membuat minimal 4 objek
        LayananMahasiswa mhs1 = new LayananMahasiswa("A-001", "22001101", "Nala Yina", "Cetak Transkrip");
        LayananMahasiswa mhs2 = new LayananMahasiswa("A-002", "22001102", "Greda Ilgan", "Legalisir Ijazah");
        LayananMahasiswa mhs3 = new LayananMahasiswa("A-003", "22001103", "Nina Adila", "KRS Bermasalah");
        LayananMahasiswa mhs4 = new LayananMahasiswa("A-004", "22001104", "Pither Futer", "Cetak KTM");

        // Menguji dengan alur normat dari menunggu - dilayani - selesai dilayani
        System.out.println("--- 1. Uji Alur Dengan Normal (Objek 1: Nala) ---");
        mhs1.mulaiDilayani();
        mhs1.selesaikanLayanan();

        // Menguji dengan alur pembatalan saat menunggu
        System.out.println("\n--- 2. Uji Pembatalan Valid (Objek 2: Greda) ---");
        mhs2.batalkanLayanan();

        // Menguji dengan perubahan status yang dimana jika sudah selesai dilayani tidak bisa kembali ke MENUNGGU
        System.out.println("\n--- 3. Uji Perubahan Status (Objek 3: Nina) ---");
        mhs3.selesaikanLayanan(); // DITOLAK: Masih MENUNGGU
        mhs3.mulaiDilayani();     // SUKSES: MENUNGGU -> DILAYANI
        mhs3.batalkanLayanan();   // DITOLAK: Sudah DILAYANI
        mhs3.selesaikanLayanan(); // SUKSES: DILAYANI -> SELESAI
        mhs3.mulaiDilayani();     // DITOLAK: Sudah SELESAI tidak bisa ke DILAYANI lagi

        // Menguji proses antrian yang dibatalkan
        System.out.println("\n--- 4. Uji Proses Antrian Batal (Objek 4: Pither) ---");
        mhs4.batalkanLayanan();   // SUKSES: MENUNGGU -> BATAL
        mhs4.mulaiDilayani();     // DITOLAK: Sudah BATAL tidak bisa dilayani kembali

        // Tampilan status akhir dari semua mehasiswa
        System.out.println("\n==============================");
        System.out.println("STATUS AKHIR SELURUH MAHASISWA");
        System.out.println("==============================");
        mhs1.cetakInfo();
        mhs2.cetakInfo();
        mhs3.cetakInfo();
        mhs4.cetakInfo();
    }
}