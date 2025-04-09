/**
 * Komponen ReturnButton untuk interaksi pengguna dalam mengembalikan sepeda
 */
public class ReturnButton implements UserInterface {
    // Referensi ke interface pengembalian
    private final ReturnInterface returnInterface;
    
    public ReturnButton(ReturnInterface returnInterface) {
        this.returnInterface = returnInterface;
    }
    
    @Override
    public void buttonPressed() {
        // Dalam aplikasi GUI nyata, ini akan memicu dialog pengembalian
        System.out.println("Return button pressed");
    }
    
    // Metode untuk memproses pengembalian sepeda berdasarkan rental ID
    public boolean returnBike(String rentalId) {
        return returnInterface.returnBike(rentalId);
    }
}
