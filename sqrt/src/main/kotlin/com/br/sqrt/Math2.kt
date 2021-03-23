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

        var aux2 = aux.toBigDecimal()

        var inc = BigDecimal("0.1")
        for (i in 0 until precision) {
            do  {
                val square2 = aux2.pow(2)
                val compared = square2.compareTo(value.toBigDecimal())
                if (compared == 1) {
                    break
                }
                aux2 = aux2.add(inc)
            } while(true)
            aux2 = aux2.subtract(inc)
            inc = inc.divide(BigDecimal.TEN)
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