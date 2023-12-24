package array

fun main() {
    println("Enter no of candies")
    val noOfCandies = readln().toInt()
    println("Enter no of people")
    val noOfPeople = readln().toInt()
    val array = distributeCandies(noOfCandies, noOfPeople)
    println(array.joinToString())
}

fun distributeCandies(candies: Int, num_people: Int): IntArray {
    val resultArray = IntArray(num_people) {0}

    var remainingCandies = candies
    var index = 0
    while (0 < remainingCandies) {
        val currentCandies = Math.min(remainingCandies, index + 1)
        resultArray[index % num_people] += currentCandies

        index++
        remainingCandies -= currentCandies
    }

    return resultArray
}