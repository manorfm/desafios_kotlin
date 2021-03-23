package com.br.tohex

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.NumberFormatException

class ToHexTest {

    @Test
    fun `given number 10 then should return 16`() {
        val value = ToHex().valueOf("10")

        Assertions.assertEquals(16, value)
    }

    @Test
    fun `given a number zero as string then should return zero as number`() {
        val value = ToHex().valueOf("0")

        Assertions.assertEquals(0, value)
    }

    @Test
    fun `given a natural number until nine then should return itself as number`() {
        val values = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

        val test: (String) -> Unit = { value: String ->
            val valueAsANumber = ToHex().valueOf(value)

            Assertions.assertEquals(value.toInt(), valueAsANumber)

        }
        values.forEach(test)
    }

    @Test
    fun `given a hex number A then should return as a number 10`() {
        val value = ToHex().valueOf("A")

        Assertions.assertEquals(10, value)
    }

    @Test
    fun `given a hex number a then should return as a number 10`() {
        val value = ToHex().valueOf("a")

        Assertions.assertEquals(10, value)
    }

    @Test
    fun `given a hex number B then should return as a number 11`() {
        val value = ToHex().valueOf("B")

        Assertions.assertEquals(11, value)
    }

    @Test
    fun `given a hex number C then should return as a number 12`() {
        val value = ToHex().valueOf("C")

        Assertions.assertEquals(12, value)
    }

    @Test
    fun `given a hex number D then should return as a number 13`() {
        val value = ToHex().valueOf("D")

        Assertions.assertEquals(13, value)
    }


    @Test
    fun `given a hex number E then should return as a number 14`() {
        val value = ToHex().valueOf("E")

        Assertions.assertEquals(14, value)
    }

    @Test
    fun `given a hex number e then should return as a number 14`() {
        val value = ToHex().valueOf("e")

        Assertions.assertEquals(14, value)
    }

    @Test
    fun `given a hex number F then should return as a number 15`() {
        val value = ToHex().valueOf("F")

        Assertions.assertEquals(15, value)
    }

    @Test
    fun `given an any other character then should throw NumberFormatException`() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            ToHex().valueOf("G")
        }
    }

    @Test
    fun `given an any other character non alphabetical then should throws NumberFormatException`() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            ToHex().valueOf(";")
        }
    }

    @Test
    fun `given a empty value then should throws NumberFormatException`() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            ToHex().valueOf("")
        }
    }

    @Test
    fun `given a space value then should throws NumberFormatException`() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            ToHex().valueOf("  ")
        }
    }

    @Test
    fun `given a hex number 10 then should return as a number 16`() {
        val value = ToHex().valueOf("10")

        Assertions.assertEquals(16, value)
    }

    @Test
    fun `given a hex number AA then should return as a number 170`() {
        val value = ToHex().valueOf("AA")

        Assertions.assertEquals(170, value)
    }

    @Test
    fun `given a hex number 1F then should return as a number 31`() {
        val value = ToHex().valueOf("1F")

        Assertions.assertEquals(31, value)
    }

    @Test
    fun `given a hex number F8A0 then should return as a number 63648`() {
        val value = ToHex().valueOf("F8A0")

        Assertions.assertEquals(63648, value)
    }
}