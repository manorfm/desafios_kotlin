package com.br.sqrt

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MathTest2 {

    @Test
    fun `given a number 4 than should return 2`() {
        val value = Math2().sqrt(4)

       Assertions.assertEquals(2, value)
    }
    @Test
    fun `given a number 9 than should return 3`() {
        val value = Math2().sqrt(9)

       Assertions.assertEquals(3, value)
    }
    @Test
    fun `given a number 16 than should return 4`() {
        val value = Math2().sqrt(16)

       Assertions.assertEquals(4, value)
    }

    @Test
    fun `given a number 144 than should return 12`() {
        val value = Math2().sqrt(144)

       Assertions.assertEquals(12, value)
    }

    @Test
    fun `given a number 1225 than should return 35`() {
        val value = Math2().sqrt(1225)

       Assertions.assertEquals(35, value)
    }

    @Test
    fun `given a number 289 than should return 17`() {
        val value = Math2().sqrt(289)

       Assertions.assertEquals(17, value)
    }

    @Test
    fun `given a number 1024 than should return 32`() {
        val value = Math2().sqrt(1024)

       Assertions.assertEquals(32, value)
    }

    @Test
    fun `given a number 225 than should return 15`() {
        val value = Math2().sqrt(225)

       Assertions.assertEquals(15, value)
    }

    @Test
    fun `given a 510 value then should return 22,5`() {
        val value = Math2().sqrt(510, 1)

       Assertions.assertEquals(22.5, value)
    }
    @Test
    fun `given a 2 value then should return 1,4142`() {
        val value = Math2().sqrt(2, 4)

       Assertions.assertEquals(1.4142, value)
    }
}