package basicMath

import kotlin.math.sqrt

fun main() {
    val isPrime = isPrime(11)
    println(isPrime)
}

fun isPrime(num: Int): Boolean {
    var i = 2
    val sqareRoot = sqrt(num.toDouble())
    while (i <= sqareRoot) {
        if(0 == num%i)
            return false
        i++
    }
    return true
}