package com.example.firebasepractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasepractice.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {
    private val vBinding by lazy{ActivityLoginBinding.inflate(layoutInflater)}
    private val fAuth by lazy{FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)

        setLoginButton()
        setRegisterTextView()
    }

    private fun setLoginButton(){
        vBinding.btnLogin.setOnClickListener{
            val email = vBinding.etIdLogin.text.toString().trim()
            val pw = vBinding.etPwLogin.text.toString().trim()
            if (email.isEmpty()) {
                vBinding.etIdLogin.error = "Empty Field"
                return@setOnClickListener
            }
            if (pw.isEmpty()){
                vBinding.etPwLogin.error = "Empty Field"
                return@setOnClickListener
            }

            vBinding.pbLogin.visibility = View.VISIBLE

            fAuth.signInWithEmailAndPassword(email, pw)
                .addOnCompleteListener{
                    vBinding.pbLogin.visibility = View.GONE
                    if(it.isSuccessful){
                        toast("Welcome, ${it.result?.user?.email}!")
                        startActivity(Intent(this, MainActivity::class.java))
                    }else{
                        toast("${it.exception?.message}")
                    }
                }
        }
    }

    private fun setRegisterTextView(){
        vBinding.tvToRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}