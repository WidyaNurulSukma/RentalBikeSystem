# RentalBikeSystem

# Rental Bike System

Sistem penyewaan sepeda yang dibangun menggunakan pendekatan **Component-Based Software Engineering (CBSE)** dengan penerapan konsep *provided* dan *required interface*.

## Deskripsi

Aplikasi ini merupakan implementasi sistem penyewaan dan pengembalian sepeda. Fitur utama dari aplikasi ini meliputi:

- Penyewaan sepeda sesuai kategori (Mountain, Road, City)
- Pembuatan ID penyewaan secara otomatis
- Validasi pengembalian sepeda
- Pencatatan dan pengecekan data penyewaan
- Manajemen inventaris sepeda

Sistem ini dirancang menggunakan prinsip CBSE dengan pendekatan *Design by Contract*, mengandalkan interaksi antar komponen melalui antarmuka (interfaces) yang jelas dan terdefinisi.

## Struktur Komponen

![ComponentDiagram](https://github.com/user-attachments/assets/dd0a20a4-7549-40d8-8d35-caae71a8f494)


Diagram sistem terdiri dari 5 komponen utama dan 4 antarmuka sebagai penghubung antar komponen:

### Komponen

#### 1. `BikeStation`
- **Provided Interface:** `RentalInterface`, `BikeInterface`
- Berfungsi untuk menangani proses penyewaan sepeda dan pencatatan data penyewaan yang valid.

#### 2. `BikeReturn`
- **Provided Interface:** `ReturnInterface`
- **Required Interface:** `BikeInterface`
- Bertugas untuk memvalidasi pengembalian sepeda dengan mengakses data dari `BikeStation`.

#### 3. `RentButton`
- **Provided Interface:** `UserInterface`
- **Required Interface:** `RentalInterface`
- Menghubungkan pengguna ke proses penyewaan sepeda.

#### 4. `ReturnButton`
- **Provided Interface:** `UserInterface`
- **Required Interface:** `ReturnInterface`
- Menghubungkan pengguna ke proses pengembalian sepeda.

#### 5. `RentalBikeSystem`
- **Required Interfaces:** `RentalInterface`, `ReturnInterface`, `BikeInterface`
- Sebagai komponen pusat sistem yang mengkoordinasikan proses penyewaan dan pengembalian sepeda melalui komponen lain.

## Antarmuka (Interface)

Berikut adalah antarmuka (contracts) yang digunakan antar komponen:

### `RentalInterface`

```java
public interface RentalInterface {
    String rentBike(String category, int hours);
}
```

Digunakan oleh `RentButton` untuk memproses penyewaan sepeda melalui `BikeStation`.

### `ReturnInterface`

```java
public interface ReturnInterface {
    boolean returnBike(String rentalId);
}
```
Digunakan oleh `ReturnButton` untuk memvalidasi pengembalian sepeda melalui `BikeReturn`.

### `BikeInterface`

```java
public interface BikeInterface {
    boolean isRentalValid(String rentalId);
    void registerRental(String rentalId, String category, int hours);
    void completeRental(String rentalId);
}
```
Digunakan oleh `BikeReturn` untuk memverifikasi data penyewaan dari `BikeStation`.

### `UserInterface`

```java
public interface UserInterface {
    void buttonPressed();
}
```
Antarmuka umum untuk tombol yang digunakan oleh pengguna (`RentButton` dan `ReturnButton`).

## Hubungan dan Ketergantungan

- `RentButton` membutuhkan `RentalInterface` dari `BikeStation`.
- `ReturnButton` membutuhkan `ReturnInterface` dari `BikeReturn`.
- `BikeReturn` membutuhkan `BikeInterface` dari `BikeStation`.
- `RentalBikeSystem` membutuhkan semua antarmuka utama untuk menjalankan sistem.

## Cara Menjalankan Aplikasi

### Prasyarat
- Java Development Kit (JDK) 8 atau lebih tinggi
- IDE seperti IntelliJ IDEA, Eclipse, atau gunakan command line

### Langkah-langkah
1. Clone repository:
   ```bash
   git clone https://github.com/username/rental-bike-system
   cd rental-bike-system
   ```

2. Kompilasi semua file Java:
   ```bash
   javac *.java
   ```

3. Jalankan aplikasi:
   ```bash
   java RentalBikeSystem
   ```

4. Ikuti petunjuk pada konsol untuk melakukan penyewaan dan pengembalian sepeda.

## Fitur

### 1. Penyewaan Sepeda
- Pilih kategori (Mountain, Road, City)
- Masukkan durasi sewa dalam jam
- Dapatkan ID penyewaan unik
- Data penyewaan disimpan dalam sistem

### 2. Pengembalian Sepeda
- Masukkan ID penyewaan
- Sistem memeriksa validitas dan status penyewaan
- Sepeda dikembalikan ke inventaris

### 3. Manajemen Inventaris
- Sistem mencatat jumlah sepeda yang tersedia untuk setiap kategori
- Jumlah sepeda diperbarui saat penyewaan dan pengembalian

## Konsep Design by Contract

Sistem ini menggunakan pendekatan Design by Contract yang mencakup:

- **Provided Interface:** Kontrak layanan yang ditawarkan oleh suatu komponen
- **Required Interface:** Kontrak layanan yang dibutuhkan dari komponen lain
- **Preconditions:** Syarat yang harus dipenuhi sebelum operasi dilakukan (misalnya, sepeda harus tersedia)
- **Postconditions:** Jaminan hasil setelah operasi selesai (misalnya, ID penyewaan valid)

## Diagram UML

![image(1)](https://github.com/user-attachments/assets/05f3e672-af1f-4663-8584-ec556bfec3c8)

# Presentasi UML Diagram Sistem Penyewaan Sepeda

## Pengantar
* Sistem penyewaan sepeda adalah aplikasi yang memungkinkan pengguna untuk menyewa dan mengembalikan sepeda
* Diagram UML ini menggambarkan struktur dan interaksi antar komponen dalam sistem

## Komponen Utama

### RentalBikeSystem
* Merupakan kelas utama yang mengkoordinasikan seluruh sistem
* Memiliki dua komponen utama: RentButton dan ReturnButton
* Bertanggung jawab untuk menciptakan (creates) seluruh komponen sistem:
  - RentButton
  - ReturnButton
  - BikeStation
  - BikeReturn

### BikeStation
* Komponen pusat yang mengelola inventaris sepeda
* Memiliki atribut:
  - inventory: Menyimpan jumlah sepeda per kategori
  - activeRentals: Daftar penyewaan yang sedang berlangsung
  - completedRentals: Daftar penyewaan yang telah selesai
* Mengimplementasikan dua interface:
  - RentalInterface: Untuk proses penyewaan
  - BikeInterface: Untuk validasi dan pengelolaan status penyewaan

### BikeReturn
* Menangani operasi pengembalian sepeda
* Memerlukan (requires) BikeInterface untuk validasi dan penyelesaian penyewaan
* Mengimplementasikan ReturnInterface

### RentButton & ReturnButton
* Komponen antarmuka pengguna untuk operasi penyewaan dan pengembalian
* Keduanya mengimplementasikan UserInterface yang menentukan perilaku tombol
* RentButton memerlukan RentalInterface
* ReturnButton memerlukan ReturnInterface

## Interface Sistem

### UserInterface
* Mendefinisikan perilaku tombol dengan metode buttonPressed()
* Diimplementasikan oleh RentButton dan ReturnButton

### RentalInterface
* Mendefinisikan operasi penyewaan sepeda
* Metode utama: rentBike(category, hours)
* Diimplementasikan oleh BikeStation

### ReturnInterface
* Mendefinisikan operasi pengembalian sepeda
* Metode utama: returnBike(rentalId)
* Diimplementasikan oleh BikeReturn

### BikeInterface
* Interface untuk manajemen inventaris dan validasi
* Metode utama:
  - isRentalValid(rentalId)
  - registerRental(rentalId, category, hours)
  - completeRental(rentalId)
* Diimplementasikan oleh BikeStation

## Alur Penyewaan Sepeda
1. Pengguna menekan RentButton (buttonPressed())
2. RentButton memanggil metode rentBike() dari RentalInterface
3. BikeStation memproses penyewaan dan menghasilkan ID penyewaan
4. BikeStation mendaftarkan penyewaan baru dengan registerRental()

## Alur Pengembalian Sepeda
1. Pengguna menekan ReturnButton (buttonPressed())
2. ReturnButton memanggil metode returnBike() dari ReturnInterface
3. BikeReturn memvalidasi ID penyewaan menggunakan isRentalValid() dari BikeInterface
4. Jika valid, BikeReturn memanggil completeRental() untuk menyelesaikan penyewaan

## Keunggulan Desain
* Modular: Setiap komponen memiliki tanggung jawab yang jelas
* Loosely coupled: Komponen berinteraksi melalui interface
* Extensible: Mudah untuk menambahkan fitur baru tanpa mengubah komponen yang ada
* Maintainable: Struktur yang jelas membuat kode mudah dirawat

## Kesimpulan
* UML diagram ini menunjukkan desain berorientasi objek yang baik dengan prinsip SOLID
* Penggunaan interface memungkinkan fleksibilitas dan testability yang tinggi
* Arsitektur yang terstruktur memudahkan pengembangan dan pemeliharaan di masa depan

## Pengembangan Selanjutnya

Beberapa ide pengembangan lebih lanjut:

- Penyimpanan data penyewaan secara permanen (misalnya ke dalam file atau database)
- GUI berbasis JavaFX atau Swing
- Sistem pembayaran dan penghitungan biaya
- Penambahan fitur lokasi untuk mendukung multiple bike stations
- Laporan statistik penggunaan sepeda berdasarkan kategori

## Anggota Tim
- Widya Nurul Sukma - 2208107010046
- Pryta Rosela - 2208107010046
