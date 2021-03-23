package com.br.tohex

class ToHex {

    private fun toValidInt(value: Char): Int {
        return when (val ascii = value.toInt()) {
            in 48..57 -> ascii - 48
            in 65..70 -> ascii - 55
            in 97..102 -> ascii - 87
            else -> throw NumberFormatException("$value is not a valid number")
        }
    }

    fun valueOf(value: String): Int {
        if (value.trim().isEmpty()) {
            throw NumberFormatException("$value is not a valid number")
        }

        val arr = value.toCharArray()
        arr.reverse()
        return arr.mapIndexed { index, c ->
            val num = toValidInt(c)
            num * 16.pow(index)
        }.reduce(process)
    }

    private fun Int.pow(index: Int): Int {
        var value = 1
        for(nun in 1..index) {
           value*=this
        }
        return value
    }

    private val process: (Int, Int) -> Int = { acc: Int, actual: Int -> acc + actual }
}