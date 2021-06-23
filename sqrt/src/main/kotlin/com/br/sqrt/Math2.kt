package com.br.sqrt

import java.math.BigDecimal

class Math2 {

    fun sqrt(value: Int, precision: Int = 1): Number {
        if (value == 0) return 0
        return binarySearch(value, precision)
    }

    private fun binarySearch(value: Int, precision: Int): Number {
        var start = 1
        var end = value
        var aux = 0
        while (start <= end) {
            val mid = start + (end - start)/2
            if (mid <= value/mid) {
                aux = mid
                start = mid + 1
            } else {
                end = mid -1
            }
        }

        val square = aux * aux
        if (square - value == 0) {
            return aux
        }

        var aux2 = aux.toDouble()
        var inc = 0.1
        for (i in 0 until precision) {
            do  {
                val square2 = aux2 * aux2 // o erro está na multiplicação
                val compared = square2.compareTo(value)
                if (compared == 1) {
                    break
                }
                aux2 += inc
            } while(true)
            aux2 -= inc
            inc /= 10
        }

        return aux2.toDouble()
    }

    /*
    var auxDouble = aux.toDouble()

        var inc = 0.1
        for (i in 0 until precision) {
            while (auxDouble * auxDouble <= value) {
                auxDouble += inc
            }
            auxDouble -= inc
            inc /= 10
        }

        return auxDouble
     */
}