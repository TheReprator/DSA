package array

fun main() {
    println("Enter fibonacci path")
    val n = readln().toInt()
    println(fibRecursive(n))
}

fun fib(n: Int): Int {

    var n1 = 0
    var n2 = 1
    var sum = 0

    var index = 1
    while (n > index) {
        sum = n1 + n2
        n1 = n2
        n2 = sum

        index++
    }

    return sum
}

fun fibRecursive(n: Int): Int {
if(1 >=n)
    return n
return fibRecursive(n -1) + fibRecursive(n-2)
}