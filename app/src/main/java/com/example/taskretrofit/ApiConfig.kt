package com.example.taskretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    // URL dasar dari API yang akan diakses// URL dasar dari API yang akan diakses
    const val baseURL = "https://rickandmortyapi.com/api/"

    // Fungsi untuk mendapatkan instance Retrofit
    fun getRetrofit(): Retrofit{
        // Membangun objek Retrofit dengan konfigurasi dasar
        return Retrofit.Builder()
            .baseUrl(baseURL)   // Mengatur URL dasar
            .addConverterFactory(GsonConverterFactory.create())    //// Menggunakan Gson sebagai konverter JSON
            .build()     // Membangun instance Retrofit
    }

    // Fungsi untuk mendapatkan instance ApiService berdasarkan konfigurasi Retrofit
    fun getService(): ApiService{
        // Membuat dan mengembalikan instance ApiService menggunakan konfigurasi Retrofit
        return getRetrofit().create(ApiService::class.java)
    }
}