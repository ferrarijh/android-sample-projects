package com.example.firebasepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasepractice.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val vBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val fAuth by lazy{ FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)

        setText()
    }

    private fun setText(){
        val txt = fAuth.currentUser?.email
        vBinding.tvMain.text = txt
    }
}