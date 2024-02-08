package basicMath

fun main() {
    val isPalimdrome = isPalimdrome(123)
    println(isPalimdrome)
}

fun isPalimdrome(num: Int): Boolean {

    val reverse = reverse(num)
    return  reverse==num
}