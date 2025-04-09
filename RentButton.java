/**
 * Komponen RentButton untuk interaksi pengguna dalam menyewa sepeda
 */
public class RentButton implements UserInterface {
    // Referensi ke interface penyewaan
    private final RentalInterface rentalInterface;
    
    public RentButton(RentalInterface rentalInterface) {
        this.rentalInterface = rentalInterface;
    }
    
    @Override
    public void buttonPressed() {
        // Dalam aplikasi GUI nyata, ini akan memicu dialog penyewaan
        System.out.println("Rent button pressed");
    }
    
    // Metode untuk menyewa sepeda berdasarkan kategori dan durasi
    public String rentBike(String category, int hours) {
        return rentalInterface.rentBike(category, hours);
    }
}
