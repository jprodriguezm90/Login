package com.jprodriguezm.login

import org.junit.Test

import org.junit.Assert.*
import java.util.*

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
    fun generateHash(){
        var password = "L0g1nP@s5"
        var hash = KnowledgeFactorySHA256.encryptThisString(password)
        var hash2 = "A60B2F89E8E636A06C58ACE213538C5F5C693E95F7F92A954F1985A7D28842E".lowercase()
        assertEquals(hash2,hash)
    }
}