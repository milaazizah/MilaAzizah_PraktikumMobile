package com.example.milaazizah_3tib

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.milaazizah_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //menyiapkan fitur view binding
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //menghubungkan file kotlin dengan layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_login)
        //memastikan isi tampilan aplikasi tidak tertutup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } 
//        val tombolLogin : Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.edtUsername)
//        val password : EditText = findViewById(R.id.edtPassword)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()
            Log.e( "Hasil","username $user Password $pass")
            //pesan pop-up singkat
            Toast.makeText(this, "username $user Password $pass", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", user)
            intent.putExtra("password", pass)
            intent.putExtra("umur", 21)

            startActivity(intent)
        }
    }
}