package array

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    //val largest = largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3))
    //val largest = largestRectangleArea(intArrayOf(6,2,5,4,5,1,6))
    val largest = largestRectangleArea(intArrayOf(2,4))
    println(largest)
}

fun largestRectangleArea(heights: IntArray): Int {
    val st = LinkedList<IntArray>()
    st.push(intArrayOf(-1, 0))
    var max = 0

    for (i in heights.indices) {
        var start = i

        while (!st.isEmpty() && st.peek()[1] > heights[i]) {
            val curr = st.pop()
            val height = curr[1]
            start = curr[0]
            max = Math.max(max, height * (i - start))
        }

        st.push(intArrayOf(start, heights[i]))
    }

    while (!st.isEmpty()) {
        val curr = st.pop()
        max = Math.max(max, curr[1] * (heights.size - curr[0]))
    }

    return max
}

private fun largestRectangleArea0(heights: IntArray): Int {
    var maxArea = Integer.MIN_VALUE

    val nextSmallerElements = nextSmallerElements(heights)
    val previousSmallerElements = previousSmallerElements(heights)

    for (index in heights.indices) {
        if(-1 == nextSmallerElements[index]) {
            nextSmallerElements[index] = heights.size
        }
        val breadth = nextSmallerElements[index] - previousSmallerElements[index] - 1
        val currentArea = heights[index]*breadth

        maxArea = max(maxArea, currentArea)
    }

    return maxArea
}

private fun nextSmallerElements(heights: IntArray): IntArray {
    val nextIndexSmallerArray = IntArray(size=heights.size){0}

    val stackIndex = Stack<Int>()
    stackIndex.push(-1)

    for (index in heights.lastIndex downTo 0) {
        while ((-1 !=stackIndex.peek()) && (heights[stackIndex.peek()] >= heights[index]))
            stackIndex.pop()

        nextIndexSmallerArray[index] = stackIndex.peek()
        stackIndex.push(index)
    }

    return nextIndexSmallerArray
}

private fun previousSmallerElements(heights: IntArray): IntArray {
    val nextIndexSmallerArray = IntArray(size=heights.size){0}

    val stackIndex = Stack<Int>()
    stackIndex.push(-1)

    for (index in 0..heights.lastIndex) {
        while ((-1 !=stackIndex.peek()) && (heights[stackIndex.peek()] >= heights[index]))
            stackIndex.pop()

        nextIndexSmallerArray[index] = stackIndex.peek()
        stackIndex.push(index)
    }

    return nextIndexSmallerArray
}

private fun largestRectangleArea1(heights: IntArray): Int {
    var maxArea = 0
    val limit = heights.lastIndex
    for (i in heights.indices) {
        var minHeight = Integer.MAX_VALUE
        for (j in i..limit) {
            minHeight = min(minHeight, heights[j])
            maxArea = max(maxArea, minHeight*(j-i+1))
        }
    }
    return maxArea
}

private fun largestRectangleAreaMySolution(heights: IntArray): Int {
    val subArrayList = mutableMapOf<Int, Int>()

    heights.distinct().forEachIndexed { _, it ->
        val element = findLargestContinuousElement(it, heights)
        val value = subArrayList.getOrDefault(it, it)
        subArrayList[it] = if (value > element)
            value
        else
            element
    }
    return subArrayList.maxOf {
        it.value
    }
}

private fun findLargestContinuousElement(element: Int, heights: IntArray): Int {

    val subList = mutableListOf<Int>()

    var index = 0

    var shouldReset = false
    var sum = 0

    while (index < heights.size) {
        val currentElement = heights[index]
        if (currentElement >= element) {
            shouldReset = true
            sum += element
        } else {
            shouldReset = false
            subList.add(sum)

            sum = 0

            val nextIndex = findNexOccuranceOfElement(index, heights, element)
            if (-1 >= nextIndex) {
                break
            }
            index ++
            continue
        }
        index++
    }


    if(shouldReset)
        subList.add(sum)

    return subList.max()
}

private fun findNexOccuranceOfElement(currentIndex: Int, heights: IntArray, elementToFind: Int): Int {
    var elementIndex = -1
    var index = currentIndex + 1
    while (index < heights.size) {
        val currentElement = heights[index]
        if(currentElement == elementToFind) {
            elementIndex = index
            break
        }

        index++
    }

    return elementIndex
}