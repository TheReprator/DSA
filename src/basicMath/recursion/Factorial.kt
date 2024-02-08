package basicMath.recursion

fun main() {
    val recursive = recursiveFactorial(4)
    println(recursive)
}

fun recursiveFactorial(num: Int): Int {
    if(num==2)
        return 2
    return num* recursiveFactorial(num-1)
}