package com.br.sqrt

class Math {

    fun sqrt(value: Int, precision: Int = 0): Number {
        val arr = toPairStr(value)
            .toCharArray()
            .toStringMutableList()

        val obj = toObject(arr, precision)
        val result = step1(obj)

        return result.div.toNumber()
    }

    private fun step1(obj: Ctrl): Ctrl {
        val rad = obj.rad

        val value = rad.removeAt(0).toInt()

        val nearNumber = getNearSquareNumber(value)
        val square = nearNumber * nearNumber
        val rest = value - square

        val isNotExact = rad.size == 0 && rest != 0

        val rasB = nearNumber * 2
        return step2(
            obj.copy(
                rad = rad,
                div = if (isNotExact) "$nearNumber." else nearNumber.toString(),
                rasA = if (rest == 0) 0 else rest,
                rasB = rasB,
                precisionCount = if (isNotExact) 1 else 0
            )
        )
    }

    private fun step2(obj: Ctrl) : Ctrl {
        val (rad, div, rasA, rasB) = obj

        if (rad.size == 0 && rasA.toInt() == 0) {
            return obj
        }

        val value = if (rad.size == 0) "" else rad.removeAt(0)

        val nextValue = if (value.isEmpty()) "${rasA}00" else "${rasA}$value"
        val productB = getNearProductB(nextValue, rasB)
        val newRasA = nextValue.toInt() - productB.product

        val isNotExact = rad.size == 0 && newRasA != 0
        if (isNotExact && obj.precisionCount == (obj.precision + 1)) {
            return obj
        }

        return step2(
            obj.copy(
            rad = rad,
            div = if (isNotExact && obj.precisionCount == 0) "${div}${productB.number}." else "${div}${productB.number}",
            rasA = newRasA,
            rasB = calcRasB(isNotExact, div, productB.number),
            precisionCount = if (isNotExact) obj.precisionCount + 1 else obj.precisionCount
        ))
    }

    private fun calcRasB(isNotExact: Boolean, div: String, number: Int): Number {
        if (isNotExact) {
            val value = div.replace(".", "") + number

            return value.toNumber().plus(2)
        }
        return 0
    }

    private fun getNearProductB (value: String, b: Number): ProductB {
        val part = value
            .toCharArray()
            .toStringMutableList()
            .filterIndexed { index, _ ->  index != value.length - 1 }
            .reduce { acc, actual ->  acc + actual }

        var number = (part.toDouble() / b.toInt()).toInt()

        var product = "$b${number}".toInt() * number
        if (number <= 9 && (value.toDouble() - product).toInt() == 0) {
            return ProductB (
                number = number,
                product = product
            )
        }

        number = 9
        do {
            val rasB = "$b$number".toInt()
            product = rasB * number
            if (product <= value.toInt()) break
            number--
        } while (true)

        return ProductB (
            number = number,
            product = product
        )
    }

    private fun getNearSquareNumber(v: Int): Int {
        var number = 1
        var square: Int
        do {
            square = number * number
            if (square > v) break
            number++
        } while (true)

        return --number
    }

    private fun toObject(arr: MutableList<String>, precision: Int): Ctrl {
        val pairList = mutableListOf<String>()

        var i = 0
        while (i < arr.size) {
            val first = arr[i]
            val second = arr[i+1]
            val value = "$first$second"
            pairList.add(value)
            i += 2
        }

        return Ctrl(
            rad = pairList,
            precision = precision
        )
    }

    private fun toPairStr(value: Int): String {
        val str = value.toString()
        if (str.length % 2 != 0) {
            return "0$str"
        }
        return str
    }

    private data class Ctrl(
        val rad: MutableList<String> = mutableListOf(),
        val div: String = "",
        val rasA: Int = 0,
        val rasB: Number = 0,
        val precision: Int = 0,
        val precisionCount: Int = 0
    )

    private fun CharArray.toStringMutableList() : MutableList<String> {
        return this.map {
            v -> v.toString()
        }.toMutableList()
    }

    private fun String.toNumber() : Number {
        return if (this.indexOf(".") == -1) this.toInt() else this.toDouble()
    }

    private fun Number.plus(n: Number) : Number {
        if (n is Int) {
            return this.toInt() * n.toInt()
        }
        return this.toDouble() * n.toDouble()
    }

    private data class ProductB (
        val number: Int,
        val product: Int
    )
}