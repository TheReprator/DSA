import kotlin.math.min

fun main() {
   //val result = findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
    val result = findMedianSortedArrays(intArrayOf(), intArrayOf(1))
    println(result)
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val length1 = nums1.size
    val length2 = nums2.size

    val totalLength = (length1 + length2)/2
    val isEven = 0 == (length1 + length2) % 2

    var last = 0
    var secondLast = 0

    var nums1Index = 0
    var nums2Index = 0

    for (index in 0..totalLength) {
        secondLast = last
        if (length1 == nums1Index) {
            last = nums2[nums2Index]
            nums2Index++
            continue
        }

        if (length2 == nums2Index) {
            last = nums1[nums1Index]
            nums1Index++
            continue
        }

        if (nums1[nums1Index] > nums2[nums2Index] ) {
            last = nums2[nums2Index]
            nums2Index++
        } else {
            last = nums1[nums1Index]
            nums1Index++
        }
    }


    val result = if (isEven)
        (last + secondLast)/2.0
    else
        last.toDouble()
    return result
}

fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    val length1 = nums1.size
    val length2 = nums2.size

    val totalLength = (length1 + length2)

    val median: Double = if (0 == totalLength % 2) {
        val t = (totalLength / 2.0)
        (t + t + 1) / 2.0
    } else {
        (totalLength + 1) / 2.0
    }

    return median
}