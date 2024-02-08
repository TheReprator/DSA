package basicMath

fun main() {
    allDivisor(11)
}

fun allDivisor(num: Int) {
    var maxLast = num

    var i = 1
    while (i < maxLast) {
        val isDivisible = num%i == 0
        if(isDivisible) {
            println(i)
            maxLast = num/i
            if(i != maxLast)
             println(maxLast)
        }
        i++
    }
}