
fun main() {
//    val result1 = lengthOfLongestSubstring("abcabcbb")
//    val result2 = lengthOfLongestSubstring("pwwkew")
//    val result3 = lengthOfLongestSubstring(" ")
    val result = lengthOfLongestSubstring("dvdf")
    println(result)
}

fun lengthOfLongestSubstring(s: String): Int {

    var max = 0
    var substring = ""

    s.forEachIndexed { index, char ->
        if(substring.contains(char)) {
            max = Math.max(substring.length, max)
            substring = "${substring.substringAfter(char)}$char"
        } else {
            substring = "$substring$char"
        }
    }
    return Math.max(substring.length, max)
}