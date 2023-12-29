package array

import kotlin.math.max

fun main() {
    val output1 = longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1),3)
    println(output1)
}

fun longestOnes(nums: IntArray, k: Int): Int {
    var maxLength = Integer.MIN_VALUE

    var kCount = 0
    var left = 0

    for (right in 0..nums.lastIndex) {
        val currentItem = nums[right]
        if(0 == currentItem) {
            kCount++
        }

        while (kCount > k) {
            if (0 == nums[left])
                kCount--
            left++
        }

        maxLength = max(maxLength, right - left + 1)
    }

    return maxLength
}