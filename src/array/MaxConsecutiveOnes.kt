package array

import kotlin.math.max
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        //val result = findMaxConsecutiveOnes(intArrayOf(0))
        val result = findMaxConsecutiveOnes(intArrayOf(1,0,1,1,0,1))
        //val result = findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1))
        println(result)
    }

    println("Time taken: $time")
}


fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCount = 0 // Initialize the maximum count to zero
    var currentCount = 0 // Initialize the current count to zero
    var mask = 0 // Initialize a bit mask to keep track of consecutive ones

    // Iterate through the ArrayList
    for (i in nums.indices) {
        // If the current element is 1, update the mask to include this one
        mask = if (nums[i] === 1) {
            mask shl 1 or 1
        } else {
            // If the current element is not 1, shift the mask left (no longer consecutive ones)
            mask shl 1
        }


        // Check if the bitwise AND of the current element and the mask is not zero
        if ((nums[i] and mask) !== 0) {
            currentCount++ // Increment the current count for consecutive ones
        } else {
            // If consecutive ones are interrupted, update the maximum count if necessary
            maxCount = max(maxCount.toDouble(), currentCount.toDouble()).toInt()
            currentCount = 0 // Reset the current count
            mask = 0 // Reset the mask
        }
    }

    // Update the maximum count one more time in case the sequence ends with consecutive ones
    maxCount = max(maxCount.toDouble(), currentCount.toDouble()).toInt()

    return maxCount
}

fun findMaxConsecutiveOnes0(nums: IntArray): Int {
    var maxConsecutiveOne = 0

    var count = 0
    for (index in 0..nums.lastIndex) {
        val outerElement = nums[index]

        if (0 == outerElement) {
            count = 0
        } else {
            count++
            maxConsecutiveOne = max(maxConsecutiveOne, count)
        }
    }

    return  maxConsecutiveOne
}

fun findMaxConsecutiveOnes1(nums: IntArray): Int {
    var maxConsecutiveOne = Integer.MIN_VALUE

    for (index in 0..nums.lastIndex) {
        val outerElement = nums[index]

        if(0 == outerElement) {
            maxConsecutiveOne = max(maxConsecutiveOne, 0)
            continue
        }

        var count = 1

        var j = index + 1
        while (j <=nums.lastIndex ) {
            if((0 == nums[j])) {
                break
            }

            j++
            count ++
        }

        maxConsecutiveOne = max(maxConsecutiveOne, count)
    }
    return  maxConsecutiveOne
}