package com.example.taskretrofit


import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    // Anotasi @GET digunakan untuk menandai bahwa metode ini akan melakukan HTTP GET request.
    // Parameter "character" merupakan bagian dari URL endpoint yang akan diakses.
    @GET ("character")

    // Fungsi yang akan mengembalikan objek Call yang berisi ResponseRick.
    // Call adalah bagian dari Retrofit yang digunakan untuk mengelola request dan response secara asynchronous.
    fun getRick(): Call<ResponseRick>
}