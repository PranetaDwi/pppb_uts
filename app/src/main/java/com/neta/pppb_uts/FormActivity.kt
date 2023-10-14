package com.neta.pppb_uts

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import com.neta.pppb_uts.databinding.ActivityFormBinding
import java.text.SimpleDateFormat
import java.util.*

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    companion object{
        const val nama_bioskop = "nama_bioskop"
        const val jenis_seat = "jenis_seat"
        const val metode = "metode"
        const val via = "via"
        const val tanggal = "tanggal"
        const val harga_per_item = "harga_per_item"
        const val total_fee = "total_fee"
        const val imagess = "imagess"
        const val nama_film = "nama_film"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = arrayOf("XXI JCM", "XXI Ambarukmo Plaza", "XXI Sleman City Hall")
        val seat = arrayOf("Regular", "Starium", "Satin Suite")
        val payment = arrayOf("Transfer Bank", "E-Wallet")
        val transfer = arrayOf("BNI", "BCA", "Mandiri")
        val wallet = arrayOf("Dana", "Gopay", "Shopeepay", "Ovo")

        val jumlah = arrayOf(1,2,3)

        with(binding){
            val bioskopadapter = ArrayAdapter(
                this@FormActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bioskop
            )
            val seatadapter = ArrayAdapter(
                this@FormActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, seat
            )
            val paymentadapter = ArrayAdapter(
                this@FormActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, payment
            )

            val jumlahadapter = ArrayAdapter(
                this@FormActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jumlah
            )


            bioskopadapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            seatadapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            paymentadapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            jumlahadapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerBioskop.adapter = bioskopadapter
            spinnerSeat.adapter = seatadapter
            spinnerMetode.adapter = paymentadapter
            spinnerJumlah.adapter = jumlahadapter

            spinnerMetode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedMethod: String = payment[position]
                    when (selectedMethod) {
                        payment[0] -> {
                            val viaAdapter = ArrayAdapter(this@FormActivity, android.R.layout.simple_spinner_item, transfer)
                            viaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinnerVia.adapter = viaAdapter
                        }
                        payment[1] -> {
                            val viaAdapter2 = ArrayAdapter(this@FormActivity, android.R.layout.simple_spinner_item, wallet)
                            viaAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinnerVia.adapter = viaAdapter2
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
            spinnerSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedSeat: String = seat[position]
                    when (selectedSeat) {
                        seat[0] -> {
                            jenisSeat.setText("Regular")
                            val hargaitem = 35000
                            harga.setText("Rp.35000")
                            spinnerJumlah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                    val selectedJumlah: Int = jumlah[position]
                                    when (selectedJumlah) {
                                        jumlah[0] -> {
                                            val totalharga = hargaitem*jumlah[0]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[1] -> {
                                            val totalharga = hargaitem*jumlah[1]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[2] -> {
                                            val totalharga = hargaitem*jumlah[2]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                    }
                                }
                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }
                        }
                        seat[1] -> {
                            jenisSeat.setText("Starium")
                            val hargaitem = 105000
                            harga.setText("Rp.105000")
                            spinnerJumlah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                    val selectedJumlah: Int = jumlah[position]
                                    when (selectedJumlah) {
                                        jumlah[0] -> {
                                            val totalharga = hargaitem*jumlah[0]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[1] -> {
                                            val totalharga = hargaitem*jumlah[1]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[2] -> {
                                            val totalharga = hargaitem*jumlah[2]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                    }
                                }
                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }
                        }
                        seat[2] -> {
                            jenisSeat.setText("Satin Suite")
                            val hargaitem = 150000
                            harga.setText("Rp150000")
                            spinnerJumlah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                    val selectedJumlah: Int = jumlah[position]
                                    when (selectedJumlah) {
                                        jumlah[0] -> {
                                            val totalharga = hargaitem*jumlah[0]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[1] -> {
                                            val totalharga = hargaitem*jumlah[1]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                        jumlah[2] -> {
                                            val totalharga = hargaitem*jumlah[2]
                                            pricetotal.setText("Rp"+totalharga.toString())
                                        }
                                    }
                                }
                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }


            dateButton.setOnClickListener{
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val cal = DatePickerDialog(this@FormActivity, { _, year, monthOfYear, dayOfMonth,  ->
                    val chosenDate = Calendar.getInstance()
                    chosenDate.set(year, monthOfYear, dayOfMonth)

                    val nameday = SimpleDateFormat("EEEE", Locale.getDefault())
                    val formatted = nameday.format(chosenDate.time)

                    dateInput.setText(formatted+" "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year)}
                    , year, month, day )
                cal.show()
            }

            val intentToDetailActivity = Intent(this@FormActivity, DetailActivity::class.java)

            backButton.setOnClickListener{
                startActivity(intentToDetailActivity)
            }

            val image_resource = intent.getIntExtra("imagess", 0)
            val title_film = intent.getStringExtra(DetailActivity.nama_film)

            order.setOnClickListener{
                val intentToTicketActivity = Intent(this@FormActivity, TicketActivity::class.java)
                intentToTicketActivity.putExtra(nama_bioskop, spinnerBioskop.selectedItem.toString())
                intentToTicketActivity.putExtra(jenis_seat, spinnerSeat.selectedItem.toString())
                intentToTicketActivity.putExtra(metode, spinnerMetode.selectedItem.toString())
                intentToTicketActivity.putExtra(via,spinnerVia.selectedItem.toString())
                intentToTicketActivity.putExtra(tanggal, dateInput.text.toString())
                intentToTicketActivity.putExtra(harga_per_item, harga.text.toString())
                intentToTicketActivity.putExtra(total_fee, pricetotal.text.toString())
                intentToTicketActivity.putExtra(imagess, image_resource)
                intentToTicketActivity.putExtra(nama_film, title_film.toString())
                startActivity(intentToTicketActivity)
            }
        }
    }
}