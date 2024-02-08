package basicMath

fun main() {
    val countDigit = countDigit(123450)
    println(countDigit)
}

fun countDigit(input: Int): Int {
    var count = 0
    var num = input
    while (num != 0) {
        num /= 10
        count++
    }
    return count
}