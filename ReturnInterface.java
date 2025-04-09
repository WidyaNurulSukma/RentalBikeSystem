/**
 * Interface untuk operasi pengembalian sepeda
 */
public interface ReturnInterface {
    /**
     * Mengembalikan sepeda berdasarkan rental ID yang diberikan
     * 
     * @param rentalId ID yang diberikan saat penyewaan
     * @return true jika pengembalian berhasil, false jika gagal
     */
    boolean returnBike(String rentalId);
}
