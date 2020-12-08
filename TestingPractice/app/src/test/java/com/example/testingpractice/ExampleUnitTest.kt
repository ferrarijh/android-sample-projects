package com.example.testingpractice

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var registrationUtil: RegistrationUtil

    @Before
    fun inject(){
        registrationUtil = RegistrationUtil()
    }

    @After
    fun destroy(){
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `assert all fields not empty and pw == pw_confirm`(){
        val result = registrationUtil.isInputValid("jiho", "12", "12")

        assertTrue(result)
    }
}