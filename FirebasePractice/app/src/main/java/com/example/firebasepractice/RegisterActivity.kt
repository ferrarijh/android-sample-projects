package com.example.firebasepractice

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasepractice.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity: AppCompatActivity() {
    companion object{
        const val TAG = "RegisterActivity"
    }
    private val vBinding by lazy{ActivityRegisterBinding.inflate(layoutInflater)}
    private val fAuth by lazy{ FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)

        setRegisterButton()
    }

    private fun setRegisterButton(){
        vBinding.btnRegister.setOnClickListener{
            val name = vBinding.etName.text.toString().trim()
            val email = vBinding.etEmail.text.toString().trim()
            val pw = vBinding.etPw.text.toString()
            val pwConfirm = vBinding.etPwConfirm.text.toString()

            if(name.isEmpty() || email.isEmpty() || pw.isEmpty() || pwConfirm.isEmpty()){
                toast("no field should be empty")
                return@setOnClickListener
            }

            pw.forEach {
                if (it == ' ') {
                    toast("password should not include empty space")
                    return@setOnClickListener
                }
            }
            if (pw.length<6){
                toast("password length should be at least 6")
                return@setOnClickListener
            }
            if (pw != pwConfirm){
                toast("please check password")
                return@setOnClickListener
            }

            vBinding.pbRegister.visibility = View.VISIBLE

            fAuth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener{
                    vBinding.pbRegister.visibility = View.GONE
                    if (it.isSuccessful) {
                        toast("Successfully registered: $email")
                        finish()    //back to login
                    }else{
                        toast("Registration failed :(")
                        Log.d(TAG, "${it.exception?.message}")
                    }
                }
        }
    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}