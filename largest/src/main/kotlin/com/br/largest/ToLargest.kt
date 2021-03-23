package com.br.largest

class ToLargest {

    fun sumTwoLarges(arr: Array<Int>): Int {
        var index = 0
        var first = 0
        var second = 0
        while (arr.size > index) {
            var aux = arr[index]

            if (first < aux) {
                second = first
                first = aux
            } else if (second < aux) {
                second = aux
            }
            index++
        }

        return first + second
    }
}