package com.neta.pppb_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.neta.pppb_uts.databinding.ActivityTicketBinding

class TicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val image_resource = intent.getIntExtra("imagess", 0)
            val pictures : ImageView = findViewById(R.id.gambar)
            pictures.setImageResource(image_resource)
            val title_film = intent.getStringExtra(FormActivity.nama_film)
            titleMovie.text = title_film
            val nama_bioskop = intent.getStringExtra(FormActivity.nama_bioskop)
            bioskop.text = nama_bioskop
            val jenis_seat = intent.getStringExtra(FormActivity.jenis_seat)
            seatType.text = jenis_seat
            seatFeeTitle.text = jenis_seat
            val metode = intent.getStringExtra(FormActivity.metode)
            val via = intent.getStringExtra(FormActivity.via)
            paymentMethod.setText(metode+" "+via)
            val tanggal = intent.getStringExtra(FormActivity.tanggal)
            dateTime.text = tanggal
            val harga_per_item = intent.getStringExtra(FormActivity.harga_per_item)
            priceSeat.text = harga_per_item
            val total_fee = intent.getStringExtra(FormActivity.total_fee)
            actualFee.text = total_fee

            val intentToFormActivity = Intent(this@TicketActivity, FormActivity::class.java)

            backButton.setOnClickListener{
                startActivity(intentToFormActivity)
            }
        }
    }
}