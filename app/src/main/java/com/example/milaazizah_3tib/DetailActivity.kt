package com.example.milaazizah_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.milaazizah_3tib.databinding.ActivityDetailBinding
import com.example.milaazizah_3tib.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Keluar Sekarang")
                .setMessage("Untuk masuk anda harus " +
                        "login kembali.")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Ya") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                .setCancelable(false)
                .show()
        }
    }
}