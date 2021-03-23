package com.br.largest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ToLargestTest {

    @Test
    fun `given an empty array then should return zero`() {
        val value = ToLargest().sumArr(emptyArray())

        Assertions.assertEquals(0, value)
    }

    @Test
    fun `given an one value on array then should return the value`() {
        val value = ToLargest().sumArr(arrayOf(5))

        Assertions.assertEquals(5, value)
    }

    @Test
    fun `given an array then should return the sum of the two largest number`() {
        val values = arrayOf(1, 10, 3, 7, 9)
        val value = ToLargest().sumArr(values)

        Assertions.assertEquals(19, value)
    }

    @Test
    fun `given a hex number A then should return as a number 10`() {
        val values = arrayOf(-2, 1, -1, 0)
        val value = ToLargest().sumArr(values)

        Assertions.assertEquals(1, value)
    }
}