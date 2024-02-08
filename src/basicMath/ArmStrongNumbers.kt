package basicMath

import kotlin.math.pow

fun main() {
    val armStrong = armStrongNumbers(153)
    val armStrong1 = armStrongNumbers(1634)
    println(armStrong)
    println(armStrong1)
}

fun armStrongNumbers(num: Int): Boolean {
    val length = num.toString().length
    var sum = 0

    var n = num
    while (0 != n) {
        val rem = n % 10
        sum +=rem.toDouble().pow(length).toInt()
        n /= 10
    }

    return sum == num
}