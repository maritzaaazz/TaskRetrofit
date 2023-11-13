package com.example.taskretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAdapter(val dataRick: List<ResultsItem>): RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    // ViewHolder untuk menyimpan referensi ke elemen tampilan dalam setiap item RecyclerView
    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick) // ImageView untuk gambar karakter Rick
        val nameRIck = view.findViewById<TextView>(R.id.item_name_rick)   // TextView untuk nama karakter Rick
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick) // TextView untuk status karakter Rick
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick) // TextView untuk spesies karakter Rick
    }

    // Membuat ViewHolder baru saat RecyclerView memerlukannya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(view)
    }

    // Mendapatkan jumlah item dalam data
    override fun getItemCount(): Int {
        if(dataRick != null){
            return dataRick.size
        }
        return 0
    }

    // Mengikat data ke ViewHolder pada posisi tertentu
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRIck.text = dataRick?.get(position)?.name
        holder.statusRick.text = dataRick?.get(position)?.status
        holder.speciesRick.text = dataRick?.get(position)?.species

        // Menggunakan Glide untuk memuat gambar dari URL ke ImageView
        Glide.with(holder.imgRick)
            .load(dataRick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background) // Menetapkan gambar default jika terjadi kesalahan
            .into(holder.imgRick)

        // Menambahkan onClickListener untuk menanggapi klik pada setiap item RecyclerView
        holder.itemView.setOnClickListener {
            val name = dataRick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }
}
