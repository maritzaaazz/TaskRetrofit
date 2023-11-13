package com.example.taskretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mendeklarasikan RecyclerView dari layout dengan ID rv_character
        val rick = findViewById<RecyclerView>(R.id.rv_character)

        // Memanggil fungsi getService() dari objek ApiConfig dan melakukan request data dengan Retrofit
        ApiConfig.getService().getRick().enqueue(object : retrofit2.Callback<ResponseRick> {
            override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>) {
                // Menangani respons berhasil dari server
                if(response.isSuccessful){
                    // Mendapatkan data dari respons
                    val responseRick = response.body()
                    val dataRick = responseRick?.results

                    // Membuat adapter untuk RecyclerView dengan menggunakan data yang diperoleh
                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)

                    // Mengatur tata letak dan adapter RecyclerView
                    rick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseRick>, t: Throwable) {
                // Menangani kegagalan saat melakukan request data
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
