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
