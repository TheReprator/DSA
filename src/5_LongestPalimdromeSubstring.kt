import kotlin.math.max

fun main() {
   // val result1 = longestPalindrome("babad")
    val result = longestPalindrome("a")
    println(result)
}

fun longestPalindrome(s: String): String {
    val subArray = s.toCharArray()

    var sub = ""
    var maxLength = Integer.MIN_VALUE

    val dp = Array(subArray.size) { IntArray(subArray.size) {-1} }

    for (diff in 0..subArray.lastIndex) {
        var i =0
        var j = i+diff
        while (j <= subArray.lastIndex) {
            if(i == j) {
                dp[i][j] = 1
            } else if(1 == diff) {
                dp[i][j] = if(subArray[i]==subArray[j])  2 else  0
            } else if((subArray[i]==subArray[j]) && (0 < dp[i+1][j-1])) {
                dp[i][j] = dp[i+1][j-1] + 2
            }

            if(0 < dp[i][j]) {
                if(j-i +1 > maxLength) {
                    maxLength = j-i +1
                    sub = s.substring(i, maxLength+i)
                }
            }
            i++
            j++
        }
    }

    return sub
}


val array = Array(1000) { IntArray(1000) {-1} }

fun longestPalindrome1(s: String): String {
    val subArray = s.toCharArray()

    var starPosition = 0
    var maxLength = Integer.MIN_VALUE

    for (i in 0..subArray.lastIndex) {
        for (j in i..subArray.lastIndex) {
            if(checkPalindrome(s, i, j)) {
                if((j - i + 1) > maxLength) {
                    maxLength = j - i + 1
                    starPosition = i
                }
            }
        }
    }

    return s.substring(starPosition, starPosition+maxLength)
}

fun checkPalindrome(string: String, i: Int, j: Int): Boolean {
    if(i >= j)
        return true

    if(array[i][j] != -1)
        return 1 == array[i][j]

    if(string[i] == string[j])
         array[i][j] = if(checkPalindrome(string, i+1, j-1))
                            1
                        else
                            0

    return 1 == array[i][j]
}
