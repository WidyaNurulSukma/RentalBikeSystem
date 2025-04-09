import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Komponen BikeStation mengelola inventaris sepeda dan operasi penyewaan
 */
public class BikeStation implements RentalInterface, BikeInterface {
    // Menyimpan jumlah sepeda yang tersedia untuk setiap kategori
    private final Map<String, Integer> inventory;
    
    // Menyimpan data penyewaan yang sedang aktif
    private final Map<String, RentalRecord> activeRentals;
    
    // Menyimpan data penyewaan yang telah selesai
    private final Map<String, RentalRecord> completedRentals;
    
    public BikeStation() {
        inventory = new HashMap<>();
        // Inisialisasi dengan jumlah sepeda untuk tiap kategori
        inventory.put("Mountain", 10);
        inventory.put("Road", 10);
        inventory.put("City", 15);
        
        activeRentals = new HashMap<>();
        completedRentals = new HashMap<>();
    }
    
    @Override
    public String rentBike(String category, int hours) {
        // Periksa apakah kategori valid
        if (!inventory.containsKey(category)) {
            return null;
        }
        
        // Periksa apakah sepeda tersedia
        int availableBikes = inventory.get(category);
        if (availableBikes <= 0) {
            return null;
        }
        
        // Kurangi jumlah sepeda dari inventaris
        inventory.put(category, availableBikes - 1);
        
        // Buat ID penyewaan (format: KATEGORI-RANDOM6ANGKA)
        String rentalId = generateRentalId(category);
        
        // Daftarkan penyewaan
        registerRental(rentalId, category, hours);
        
        return rentalId;
    }
    
    @Override
    public boolean isRentalValid(String rentalId) {
        // Periksa apakah ID penyewaan terdaftar dalam penyewaan aktif
        return activeRentals.containsKey(rentalId);
    }
    
    @Override
    public void registerRental(String rentalId, String category, int hours) {
        // Simpan data penyewaan ke daftar penyewaan aktif
        RentalRecord record = new RentalRecord(rentalId, category, hours);
        activeRentals.put(rentalId, record);
    }
    
    @Override
    public void completeRental(String rentalId) {
        // Jika ID penyewaan masih aktif, pindahkan ke daftar selesai
        if (activeRentals.containsKey(rentalId)) {
            RentalRecord record = activeRentals.remove(rentalId);
            completedRentals.put(rentalId, record);
            
            // Tambahkan kembali sepeda ke inventaris
            String category = record.getCategory();
            inventory.put(category, inventory.get(category) + 1);
        }
    }
    
    private String generateRentalId(String category) {
        // Membuat angka acak 6 digit untuk ID penyewaan
        Random random = new Random();
        int randomDigits = 100000 + random.nextInt(900000); // 6-digit number
        return category.substring(0, 1).toUpperCase() + "-" + randomDigits;
    }
    
    // Kelas dalam untuk menyimpan data penyewaan
    private static class RentalRecord {
        private final String rentalId;
        private final String category;
        private final int hours;
        private final long timestamp;
        
        public RentalRecord(String rentalId, String category, int hours) {
            this.rentalId = rentalId;
            this.category = category;
            this.hours = hours;
            this.timestamp = System.currentTimeMillis();
        }
        
        public String getRentalId() {
            return rentalId;
        }
        
        public String getCategory() {
            return category;
        }
        
        public int getHours() {
            return hours;
        }
        
        public long getTimestamp() {
            return timestamp;
        }
    }
}
