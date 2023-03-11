package com.example.fluffyonebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    private lateinit var kittyPicture: ImageView
    private lateinit var nextKittyButton: Button
    //private val adapter = AppAdapter()
    //private lateinit var recyclerView: RecyclerView
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kittyPicture = findViewById(R.id.kittyImage)
        nextKittyButton = findViewById(R.id.nextKittyButton)

        nextKittyButton.setOnClickListener {

        }

        loadPicture()
    }
    private fun loadPicture(){
        Glide
            .with(this)
            .load("https://cdn2.thecatapi.com/images/dia.jpg")
            .into(kittyPicture)
    }

    private fun randomPic(){
        Glide
            .with(holder.itemView)
            .load(data[position].url)
            .centerCrop()
            .into(holder.picture)
    }
}