package com.example.kotlinapp

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
    fun addition_isWrong() {
        assertNotEquals(4, 2 + 3)
    }

    @Test
    fun jenkins_status_test() {
        assertEquals(5, 2 + 3)
    }

    @Test
    fun jenkins_status_failed() {
        assertNotEquals(6, 2 + 3)
    }
}
