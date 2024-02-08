package basicMath.recursion

fun main() {
    val lenght = 0
    for (i in 0..lenght){
        print(recursiveFibonacci(i))
    }

}

fun recursiveFibonacci(num: Int): Int {

    // Base Condition.
    if (num <= 1) {
        return num
    }

    // Problem broken down into 2 functional calls
    // and their results combined and returned.
    val last: Int = recursiveFibonacci(num - 1)
    val slast: Int = recursiveFibonacci(num - 2)

    return last + slast
}