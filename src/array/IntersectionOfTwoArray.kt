package array

fun main() {
    val intersection = intersection(intArrayOf(1,2,2,1), intArrayOf(2,2))
    //val intersection = intersection(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))
    println(intersection.joinToString())
}
fun intersection1(nums1: IntArray, nums2: IntArray): IntArray {
    val mutableMap = mutableMapOf<Int, Int>()

    nums1.distinct().forEach {
        val element = if(mutableMap.containsKey(it)) {
            mutableMap[it]!! + 1
        } else {
            1
        }

        mutableMap[it] = element
    }

    nums1.distinct().forEach {
        val element = if(mutableMap.containsKey(it)) {
            mutableMap[it]!! + 1
        } else {
            1
        }

        mutableMap[it] = element
    }
    nums2.distinct().forEach {
        val element = if(mutableMap.containsKey(it)) {
            mutableMap[it]!! + 1
        } else {
            1
        }

        mutableMap[it] = element
    }

    val resultArray = ArrayList<Int>()
     mutableMap.filterValues {
        it > 1
    }.forEach {
        resultArray.add(it.key)
    }

    return resultArray.toIntArray()
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val a: MutableMap<Int, Int> = mutableMapOf()
    for (i in nums1.indices) {
        a[nums1[i]] = a.getOrDefault(nums1[i], 0) + 1
    }
    val s = mutableSetOf<Int>()
    for (i in nums2.indices) {
        if (a.getOrDefault(nums2[i], 0)> 0) {
            s.add(nums2[i])
        }
    }
    return s.toIntArray()
}