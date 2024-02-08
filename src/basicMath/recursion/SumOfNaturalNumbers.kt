package basicMath.recursion

fun main() {
    val recursive = recursiveSum(3)
    println(recursive)
}

fun recursiveSum(num: Int): Int {
    if(0 == num)
        return 0

    return num + recursiveSum(num - 1)
}