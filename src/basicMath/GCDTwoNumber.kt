package basicMath

fun main() {
    val gcd = gcd(52,10)
    println(gcd)
}

fun gcd(num1: Int, num2: Int): Int {

    if(0 == num1)
        return num2

    if(0 == num2)
        return num1

    val a = if(num1 > num2)
        num1 to num2
    else
        num2 to num1

    return gcd(a.first% a.second, a.second)
}

