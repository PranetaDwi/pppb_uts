package com.neta.pppb_uts

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.neta.pppb_uts.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginButton.setOnClickListener {
                val usernameinput = namaPenonton.text.toString()
                val passwordinput = passwordPenonton.text.toString()
                val intentToHomeActivity = Intent(this@LoginActivity, HomeActivity::class.java)
                if (usernameinput.equals("Padma") && passwordinput.equals("bujang")) {
                    intentToHomeActivity.putExtra(EXTRA_NAME, usernameinput)
                    Toast.makeText(this@LoginActivity, "Login Successfull", Toast.LENGTH_LONG).show()
                    startActivity(intentToHomeActivity)
                } else {Toast.makeText(this@LoginActivity, "Incorrect", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}