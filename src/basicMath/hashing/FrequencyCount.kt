package basicMath.hashing

fun main() {
    val frequencount = frequencyCount(intArrayOf(10,5,10,15,10,5))
    for (i in frequencount) {
        println("${i.key} ${i.value.size}")
    }
}

fun frequencyCount(input: IntArray): Map<Int, List<Int>> {
    return input.groupBy {
        it
    }
}