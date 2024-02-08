package basicMath.recursion

fun main() {
    val array = intArrayOf(5,4,3,2)
    val length = (array.size/2) - 1

    val recursiveArray = recursiveArray( array, length)
    recursiveArray.forEach {
        println(it)
    }
}

fun recursiveArray(num: IntArray, position: Int): IntArray {
    if(-1 == position) {
        return num
    }

    val last = num.lastIndex - position
    val temp = num[last]
    num[last] = num[position]
    num[position] = temp
    return recursiveArray(num, position-1)
}