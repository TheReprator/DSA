fun main() {
    val result = convert("PAYPALISHIRING", 3)
    println(result)
}

fun convert(s: String, numRows: Int): String {
    val arrayList = Array(size = numRows) {StringBuilder()}

    if(1 >= numRows)
        return s

    var i = 0
    var isBottom = false

    s.forEachIndexed { _, c ->
        val item = arrayList[i]
        item.append(c)

        if((0 == i) || (numRows-1) == i)
            isBottom = !isBottom

        if(isBottom)
            i++
        else
            i--
    }


    val sub = StringBuilder()
    for (item in arrayList) {
        sub.append(item)
    }

    return sub.toString()
}