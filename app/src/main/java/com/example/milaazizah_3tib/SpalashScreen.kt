package com.example.milaazizah_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SpalashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
//      Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            startActivity(Intent(this, BaseActivity::class.java))
            finish()
            return
        }

        lifecycleScope.launch {
            delay(2000) //simulasi pengambilan data 2 detik
            val intent= Intent(this@SpalashScreen, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}