package com.example.finalproject

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun substitution_isCorrect() {
        assertEquals(5, 9-4)
    }

    @Test
    fun multiplication_isCorrect() {
        assertEquals(35, 7*5)
    }

    @Test
    fun division_isCorrect() {
        assertEquals(2, 4/2)
    }
}