package com.neta.pppb_uts

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.neta.pppb_uts.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val imagess = "imagess"
        const val nama_film = "nama_film"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val image_detail = intent.getIntExtra("img", 0)
            val imageView: ImageView = findViewById(R.id.img)
            imageView.setImageResource(image_detail)
            val title_detail = intent.getStringExtra(HomeActivity.titles)
            title.text = title_detail
            val director_detail = intent.getStringExtra(HomeActivity.director)
            director.setText("Directed By: "+ director_detail)
            val rate_detail = intent.getStringExtra(HomeActivity.rate)
            rate.text = rate_detail
            val storyline_detail = intent.getStringExtra(HomeActivity.storyline)
            storyline.text = storyline_detail


            val intentToHomeActivity = Intent(this@DetailActivity, HomeActivity::class.java)
            backButton.setOnClickListener{
                startActivity(intentToHomeActivity)
            }

            val intentToFormActivity = Intent(this@DetailActivity, FormActivity::class.java)
            val intentToTicketActivity = Intent(this@DetailActivity, TicketActivity::class.java)
            getTicket.setOnClickListener{
                intentToFormActivity.putExtra(imagess, image_detail)
                intentToFormActivity.putExtra(nama_film, title_detail)
                startActivity(intentToFormActivity)
            }

        }
    }
}