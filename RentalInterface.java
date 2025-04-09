/**
 * Interface untuk operasi penyewaan sepeda
 */
public interface RentalInterface {
    /**
     * Menyewa sepeda berdasarkan kategori dan durasi tertentu
     * 
     * @param category Kategori sepeda (Mountain, Road, City)
     * @param hours Durasi penyewaan dalam jam
     * @return ID penyewaan atau null jika sepeda tidak tersedia
     */
    String rentBike(String category, int hours);
}
