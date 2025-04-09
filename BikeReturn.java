/**
 * Komponen BikeReturn menangani operasi pengembalian sepeda
 */
public class BikeReturn implements ReturnInterface {
    // Menyimpan referensi ke objek yang mengimplementasikan BikeInterface
    private final BikeInterface bikeInterface;
    
    // Konstruktor untuk menginisialisasi BikeReturn dengan BikeInterface
    public BikeReturn(BikeInterface bikeInterface) {
        this.bikeInterface = bikeInterface;
    }
    
    @Override
    public boolean returnBike(String rentalId) {
        // Memeriksa apakah ID penyewaan valid
        if (bikeInterface.isRentalValid(rentalId)) {
            // Menandai penyewaan sebagai selesai jika ID valid
            bikeInterface.completeRental(rentalId);
            return true;
        }
        // Mengembalikan false jika ID penyewaan tidak valid
        return false;
    }
}
