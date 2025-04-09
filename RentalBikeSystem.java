import java.util.Scanner;

/**
 * Kelas utama sistem yang mengoordinasikan sistem penyewaan sepeda
 */
public class RentalBikeSystem {
    // Komponen tombol penyewaan
    private final RentButton rentButton;
    
    // Komponen tombol pengembalian
    private final ReturnButton returnButton;
    
    public RentalBikeSystem() {
        // Inisialisasi komponen pusat (BikeStation)
        BikeStation bikeStation = new BikeStation();
        
        // Inisialisasi pintu masuk untuk pengembalian sepeda
        BikeReturn bikeReturn = new BikeReturn(bikeStation);
        
        // Inisialisasi komponen antarmuka pengguna
        this.rentButton = new RentButton(bikeStation);
        this.returnButton = new ReturnButton(bikeReturn);
    }
    
    public void start() {
        // Variabel kontrol untuk menjalankan loop utama
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        
        while (running) {
            // Tampilkan menu utama
            System.out.println("===============================================");
            System.out.println("         RENTAL BIKE SYSTEM");
            System.out.println("===============================================");
            System.out.println("1. Rent a Bike");
            System.out.println("2. Return a Bike");
            System.out.println("3. Exit");
            System.out.println("===============================================");
    
            System.out.print("Select an option (1-3): ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    // Proses penyewaan
                    rentBike(scanner);
                    break;
                case "2":
                    // Proses pengembalian
                    returnBike(scanner);
                    break;
                case "3":
                    // Keluar dari sistem
                    System.out.println("Thank you for using the Rental Bike System. Goodbye!");
                    running = false;
                    break;
                default:
                    // Input tidak valid
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        
        // Tutup scanner setelah selesai
        scanner.close();
    }
    
    
    private void rentBike(Scanner scanner) {
        System.out.println("\n--- RENT A BIKE ---");
        System.out.println("Bike Categories:");
        System.out.println("1. Mountain Bike");
        System.out.println("2. Road Bike");
        System.out.println("3. City Bike");
        
        System.out.print("Select bike category (1-3): ");
        String categoryChoice = scanner.nextLine();
        
        String category;
        // Konversi pilihan menjadi kategori sepeda
        switch (categoryChoice) {
            case "1":
                category = "Mountain";
                break;
            case "2":
                category = "Road";
                break;
            case "3":
                category = "City";
                break;
            default:
                System.out.println("Invalid category. Using City Bike as default.");
                category = "City";
                break;
        }
        
        System.out.print("Enter rental duration in hours: ");
        int hours;
        try {
            // Validasi input durasi penyewaan
            hours = Integer.parseInt(scanner.nextLine());
            if (hours <= 0) {
                System.out.println("Hours must be positive. Using 1 hour as default.");
                hours = 1;
            }
        } catch (NumberFormatException e) {
            // Jika input tidak valid, gunakan default 1 jam
            System.out.println("Invalid input. Using 1 hour as default.");
            hours = 1;
        }
        
        // Simulasi penekanan tombol
        rentButton.buttonPressed();
        
        // Proses penyewaan
        String rentalId = rentButton.rentBike(category, hours);
        if (rentalId != null) {
            System.out.println("\nBike successfully rented!");
            System.out.println("Your Rental ID: " + rentalId);
            System.out.println("Please keep this ID for when you return the bike.");
        } else {
            System.out.println("\nSorry, no bikes available in this category.");
        }
        
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    private void returnBike(Scanner scanner) {
        System.out.println("\n--- RETURN A BIKE ---");
        
        System.out.print("Enter your Rental ID: ");
        String rentalId = scanner.nextLine();
        
        // Simulasi penekanan tombol
        returnButton.buttonPressed();
        
        // Proses pengembalian
        boolean result = returnButton.returnBike(rentalId);
        
        if (result) {
            System.out.println("\nBike successfully returned!");
            System.out.println("Thank you for using our service.");
        } else {
            System.out.println("\nInvalid Rental ID. Please check your ID and try again.");
        }
        
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        // Jalankan sistem penyewaan sepeda
        RentalBikeSystem rentalBikeSystem = new RentalBikeSystem();
        rentalBikeSystem.start();
    }
}
