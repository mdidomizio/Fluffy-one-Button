package com.example.fluffyonebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.fluffyonebutton.API.api
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    private lateinit var kittyPicture: ImageView
    private lateinit var nextKittyButton: Button
    private lateinit var data: PhotoGalleryClass
    //private val adapter = AppAdapter()
    //private lateinit var recyclerView: RecyclerView
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        kittyPicture = findViewById(R.id.kittyImage)
        nextKittyButton = findViewById(R.id.nextKittyButton)

        nextKittyButton.setOnClickListener {
            //addPic()
            loadPicture()
        }

        //loadPicture()
    }

    // this fun is loading a single pic via its URL
    private fun loadPicture() {
        val baseUrl = "https://cdn2.thecatapi.com/images/"

        val listContent = arrayOf (
            "90c.jpg",
            "5q.jpg",
            "MTkyNzQ3NA.gif",
            "8of.jpg",
            "eh3.jpg",
            "125.jpg",
            "2sd.jpg",
            "pl.jpg",
            "b8n.jpg",
            "27i.jpg",
            "MTY2Nzg4MQ.jpg",
            "552.jpg",
            "MTg3MTgxMw.gif",
            "4ua.jpg",
            "5jf.jpg",
            "nJsljkalm.jpg",
            "asr.jpg",
            "bo9.jpg",
            "MTY2MTMzMQ.jpg",
            "9sj.jpg",
            "e1q.jpg",
            "1a9.gif",
            "bo6.jpg",
            "cp0.jpg",
            "tt01SNoSH.png"
        )

        Glide
            .with(this)
            .load( "$baseUrl${listContent.random()}")
            .into(kittyPicture)
    }

    private fun addPic() {
        Log.d("TAG123", "Hello there1")

        api.getRandomPic().enqueue(object: Callback<PhotoGalleryClass> {
            override fun onResponse(
                call: Call<PhotoGalleryClass>,
                response: Response<PhotoGalleryClass>
            ) {

                Log.d("TAG123", "Hello there2")
                /*Log.d("TAG123", "hello")
                Log.d("TAG123", "running until urls ${response.code()}")


                val responseInstance = response.body()

                if (responseInstance != null){
                    data = responseInstance
                    Log.d("TAG123", "data $data")
                }*/
            }
            override fun onFailure(call: Call<PhotoGalleryClass>, t: Throwable) {
                Toast.makeText(
                    applicationContext, "Something went wrong with the fluffy kitty picture", Toast.LENGTH_SHORT
                ).show()
            }
        })

        /*Glide
            .with(this)
            .load(data.url)
            .centerCrop()
            .into(kittyPicture) */



    }
}
//class Content (val url: String)