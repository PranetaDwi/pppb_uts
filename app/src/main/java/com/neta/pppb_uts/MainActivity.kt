package com.neta.pppb_uts

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 3000L)
    }
}