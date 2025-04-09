/**
 * Antarmuka untuk manajemen inventaris sepeda
 */
public interface BikeInterface {
    
    /**
     * Memeriksa apakah ID penyewaan valid
     *
     * @param rentalId ID penyewaan yang akan diperiksa
     * @return true jika valid, false jika tidak
     */
    boolean isRentalValid(String rentalId);

    /**
     * Mendaftarkan penyewaan ke dalam sistem
     *
     * @param rentalId ID dari penyewaan
     * @param category Kategori sepeda yang disewa
     * @param hours Durasi penyewaan dalam jam
     */
    void registerRental(String rentalId, String category, int hours);

    /**
     * Menandai penyewaan sebagai selesai
     *
     * @param rentalId ID dari penyewaan yang telah selesai
     */
    void completeRental(String rentalId);
}
