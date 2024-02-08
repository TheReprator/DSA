package basicMath.hashing

fun main() {
    //val highiesLowest = highiestLowestFrequency(intArrayOf(10,5,10,15,10,5))
    val highiesLowest = highiestLowestFrequency(intArrayOf(2, 2, 3, 4, 4, 2))
    println("${highiesLowest.first} ${highiesLowest.second}")
}

fun highiestLowestFrequency(array: IntArray): Pair<Int, Int> {
    val newArray = array.groupBy {
        it
    }.map {
        it.key to it.value.size
    }

    val max =  newArray.maxBy {
        it.second
    }.first

    val min = newArray.minBy { it.second }.first

    return Pair(max, min)
}