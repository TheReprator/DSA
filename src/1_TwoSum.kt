fun main() {
    val tp = 9 / 10
    val tp1 = 2 / 10
    val tp2 = 3 / 10
    val tp3 = 11 / 10
    val tp4 = 10 / 10
    val result = twoSum(intArrayOf(2,7,11,15), 9)
    val result1 = twoSum(intArrayOf(3,2,4), 6)
    println(result1)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val mapWithIndex = mutableMapOf<Int, Int>()

    nums.forEachIndexed { index, i ->
        mapWithIndex[i] = index
    }

    var pair: Pair<Int, Int> ?= null
    for (index in nums.indices) {
        val diff = target - nums[index]
        if(mapWithIndex.containsKey(diff) && (mapWithIndex[diff]!! != index)) {
            pair = Pair(index, mapWithIndex[diff]!!)
            break
        }
    }

    return intArrayOf(pair!!.first, pair.second)
}