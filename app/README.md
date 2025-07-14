# Dokumentasi REST API: Prediksi Kualitas Air

## 1. Ringkasan Proyek

Proyek ini adalah sebuah REST API yang dibangun menggunakan framework FastAPI untuk memberikan layanan prediksi kualitas
air berdasarkan parameter-parameter tertentu. API ini dirancang untuk dapat diintegrasikan dengan mudah ke dalam
aplikasi lain, baik itu web maupun mobile, yang membutuhkan data prediksi kelayakan air.

Proyek ini sudah di-deploy dan dapat diakses secara publik. Selain itu, tersedia juga Docker image untuk mempermudah
proses build dan deployment di lingkungan yang berbeda.

## 2. Fitur Utama

- **Prediksi Real-time**: Memberikan hasil prediksi kualitas air secara cepat.
- **Berbasis REST API**: Menggunakan standar HTTP untuk kemudahan integrasi.
- **Dokumentasi Interaktif**: Dokumentasi API otomatis yang disediakan oleh FastAPI (Swagger UI & ReDoc).
- **Containerized**: Dikemas dalam Docker container untuk portabilitas dan skalabilitas.
- **Manajemen Lingkungan**: Menggunakan Miniconda untuk manajemen environment dan dependensi Python.

## 3. Tumpukan Teknologi (Tech Stack)

- **Bahasa Pemrograman**: Python 3.x
- **Framework**: FastAPI
- **Server**: Uvicorn
- **Containerization**: Docker
- **Environment Manager**: Miniconda

## 4. Struktur Proyek

Proyek ini disusun dengan arsitektur yang bersih dan modular untuk memisahkan setiap concern, sehingga mudah untuk
dikelola dan dikembangkan lebih lanjut.

```text
water-quality-ml/
├── app/
│   ├── core/
│   │   ├── init.py
│   │   ├── config.py         # Konfigurasi aplikasi (env variables, settings)
│   │   └── database.py       # Konfigurasi koneksi database
│   ├── entity/
│   │   ├── init.py
│   │   ├── user.py           # Model entitas untuk pengguna
│   │   └── user_detail.py    # Model entitas untuk detail pengguna
│   ├── infrastructure/
│   │   ├── api/              # Router dan definisi endpoint API
│   │   ├── dto/              # Data Transfer Objects (Pydantic models)
│   │   ├── middleware/       # Custom middleware (CORS, logging, etc)
│   │   ├── model/            # Lokasi untuk file model machine learning
│   │   ├── mqtt/             # Komponen terkait MQTT (jika ada)
│   │   └── security/         # Skema otentikasi dan utilitas keamanan
│   ├── repository/
│   │   └── init.py       # Layer untuk abstraksi akses data
│   ├── service/
│   │   ├── init.py
│   │   └── prediction_service.py # Logika bisnis untuk layanan prediksi
│   └── util/
│       └── init.py       # Fungsi-fungsi utilitas
├── .env                      # File untuk menyimpan environment variables
├── .gitignore                # File yang diabaikan oleh Git
├── main.py                   # Entry point utama aplikasi FastAPI
└── README.md                 # File dokumentasi ini

```

## 5. Instalasi dan Menjalankan Proyek

Ada dua cara untuk menjalankan proyek ini: secara lokal menggunakan Miniconda atau menggunakan Docker.

### 5.1. Menjalankan Secara Lokal (dengan Miniconda)

**Prasyarat**:

- Miniconda/Anaconda terinstal.

**Langkah-langkah**:

1. **Clone repository ini:**
   ```bash
   git clone <URL_REPOSITORY_ANDA>
   cd water-quality-ml
   ```

2. **Buat environment conda:**
   (Asumsi Anda memiliki file `environment.yml`)
   ```bash
   conda env create -f environment.yml
   ```
   Jika tidak ada, buat secara manual:
   ```bash
   conda create --name water-quality-env python=3.9
   conda activate water-quality-env
   ```

3. **Install dependensi:**
   ```bash
   pip install -r requirements.txt
   ```

4. **Konfigurasi Environment Variable:**
   Buat file `.env` di root direktori proyek dengan meniru file `.env.example` (jika ada).

5. **Jalankan server Uvicorn:**
   ```bash
   uvicorn main:app --host 0.0.0.0 --port 8000 --reload
   ```
   Aplikasi sekarang berjalan di `http://localhost:8000`.

### 5.2. Menjalankan dengan Docker

**Prasyarat**:

- Docker terinstal dan berjalan.

**Langkah-langkah**:

1. **Clone repository ini:**
   ```bash
   git clone <URL_REPOSITORY_ANDA>
   cd water-quality-ml
   ```

2. **Build Docker image:**
   ```bash
   docker build -t water-quality-api .
   ```

3. **Jalankan Docker container:**
   ```bash
   docker run -d -p 8000:8000 --name water-quality-container water-quality-api
   ```
   Aplikasi sekarang berjalan di `http://localhost:8000`.

## 6. Dokumentasi API (Endpoint)

FastAPI secara otomatis menghasilkan dokumentasi interaktif. Setelah aplikasi berjalan, Anda dapat mengaksesnya melalui:

- **Swagger UI**: `http://<ALAMAT_IP_ANDA>:8000/docs`
- **ReDoc**: `http://<ALAMAT_IP_ANDA>:8000/redoc`

### Contoh Endpoint: Prediksi Kualitas Air

Berikut adalah contoh hipotetis untuk endpoint prediksi.

- **URL**: `/api/v1/predict`
- **Method**: `POST`
- **Body Request**:
  ```json
  {
    "ph": 7.0,
    "Hardness": 150.0,
    "Solids": 20000.0,
    "Chloramines": 7.0,
    "Sulfate": 300.0,
    "Conductivity": 400.0,
    "Organic_carbon": 15.0,
    "Trihalomethanes": 60.0,
    "Turbidity": 4.0
  }
  ```
- **Response Sukses (200 OK)**:
  ```json
  {
    "prediction": 1,
    "status": "Potable",
    "confidence_score": 0.92
  }
  ```
  *Catatan: `1` berarti layak minum, `0` berarti tidak layak minum.*

## 7. Deployment

API ini telah di-deploy dan dapat diakses secara publik melalui URL berikut:

**[https://airsehat.refanzzzz.cloud](https://airsehat.refanzzzz.cloud)**

Anda dapat mencoba mengakses endpoint `/docs` pada URL di atas untuk berinteraksi langsung dengan API yang sudah live.