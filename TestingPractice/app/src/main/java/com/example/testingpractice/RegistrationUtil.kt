package com.example.testingpractice

class RegistrationUtil {



    companion object {
        const val ID = 1994
    }

    fun isInputValid(username: String, pw: String, pwConfirm: String): Boolean{
        return if (username.isEmpty() || pw.isEmpty() || pwConfirm.isEmpty())
            false
        else pw == pwConfirm
    }
}