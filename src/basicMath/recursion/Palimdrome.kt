package basicMath.recursion

fun main() {
    val input = "abcdcba"
    val size = (input.length / 2) - 1
    val isPalimdrome = palimdromeRecursion(input, size)
    println(isPalimdrome)
}


fun palimdromeRecursion(string: String, position: Int): Boolean {

    if (-1 == position) {
        return true
    }

    val last = string.lastIndex - position
    if(string[last].lowercaseChar() == string[position].lowercaseChar())
        return palimdromeRecursion(string, position-1)
    else
        return false
}