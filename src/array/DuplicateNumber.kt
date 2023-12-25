package array

fun main(){
   val element = findDuplicate(intArrayOf(3,1,3,4,2))
    println(element)
}

fun findDuplicate(nums: IntArray): Int {
    val mutableMap = mutableMapOf<Int, Int>()
    for (i in nums) {
        val count = if(mutableMap.containsKey(i))
            mutableMap[i]!! + 1
        else
            1
        mutableMap[i] = count
    }

    val element = mutableMap.maxBy {
        it.value
    }

    return element.key
}