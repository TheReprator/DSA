package basicMath

fun main() {
    val reverse = reverse(123)
    println(reverse)
}

fun reverse(num: Int): Int {
    var reverse = 0

    var newNum = num
    while (newNum !=0) {
        reverse = reverse*10 + newNum%10
        newNum /= 10
    }

    return reverse
}