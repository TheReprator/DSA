package array

fun main() {
    val insertAll = insert(intervals = arrayOf(intArrayOf(1,2),intArrayOf(3,5),intArrayOf(6,7),intArrayOf(8,10),intArrayOf(12,16)), newInterval= intArrayOf(4,8))
    //val insertAll = insert(intervals = arrayOf(intArrayOf(1,3),intArrayOf(6,9)), newInterval= intArrayOf(2,5))
    //val insertAll = insert(intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 6)), newInterval = intArrayOf(2, 5))
    println(insertAll.joinToString(separator = "\n") {
        "${it.first()},${it.last()}"
    })
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val res = ArrayList<IntArray>()
    var added = false
    var index = 0

    for (element in intervals) {
        if (newInterval[0] > element[1]) { //non overlapping
            res.add(element)
        } else if (newInterval[1] < element[0]) { //no more overlapping intervals
            res.add(newInterval)
            added = true
            break
        } else { //overlapping, update the new interval accordingly
            newInterval[0] = minOf(newInterval[0], element[0])
            newInterval[1] = maxOf(newInterval[1], element[1])
        }
        index++
    }

    if (index < intervals.size) { // add all the leftover intervals (after the break)
        for (i in index..<intervals.size)
            res.add(intervals[i])
    }

    if (!added) // takes care of (1) Empty intervals array or 1-sized array with overlapping newinterval
        res.add(newInterval)
    return res.toTypedArray()
}