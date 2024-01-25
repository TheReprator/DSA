package pattern

fun main() {
    pattern1()

    println()
    println()

    pattern2()

    println()
    println()

    pattern3()

    println()
    println()

    pattern4()

    println()
    println()

    pattern5()

    println()
    println()

    pattern6()

    println()
    println()

    pattern7()

    println()
    println()

    pattern8()

    println()
    println()

    pattern9()

    println()
    println()

    pattern10()
}


/*
 *****
 *****
 *****
 *****
 *****
* */

fun pattern1() {
    val limit = 5
    for (i in 0..<limit) {
        for (j in 0..<limit) {
            print("*")
        }
        println()
    }
}

/*
 *
 **
 ***
 ****
 *****
* */

fun pattern2() {

    val limit = 5
    for (i in 0..limit) {

        var j = 0
        while (j <= i) {
            print("*")
            j++
        }
        println()
    }
}

/*

 *****
 ****
 ***
 **
 *

* */

fun pattern3() {

    val limit = 4
    for (i in limit downTo 0) {

        var j = 0
        while (j <= i) {
            print("*")
            j++
        }
        println()
    }

}


/*
    *
   ***
  *****
 *******
*********

* */

fun pattern4() {

    val limit = 5
    for (i in 1..limit) {

        for (e in limit downTo i) {
            print(" ")
        }

        val jLimit = 2 * i - 1
        var j = 1
        while (j <= jLimit) {
            print("*")
            j++
        }
        println()
    }
}

/*

*********
 *******
  *****
   ***
    *

* */

fun pattern5() {

    val limit = 5
    for (i in limit downTo 1) {

        for (e in limit downTo i) {
            print(" ")
        }

        val jLimit = 2*i - 1
        var j = 1
        while (j <= jLimit){
            print("*")
            j++
        }
        println()
    }
}


/*

    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

* */

fun pattern6() {

    pattern4()
    pattern5()
}


/*

     *
     **
     ***
     ****
     *****
     ****
     ***
     **
     *

* */

fun pattern7() {

    val limit = 5
    for (i in 1..limit) {
        var j = 1
        while (j <= i) {
            print("*")
            j++
        }
        println()
    }
    for (i in (limit - 1) downTo 1) {
        var j = i
        while (j > 0) {
            print("*")
            j--
        }
        println()
    }
}


/*

1
0 1
1 0 1
0 1 0 1
1 0 1 0 1

* */

fun pattern8() {

    val limit = 4
    for (i in 0..limit) {
        val c = 1+i
        var j = 0
        while (j <= i) {
           val isZero = (c+j)%2 == 0
            if(isZero)
                print(0)
            else
                print(1)
            j++
        }
        println()
    }
}


/*

1      1
12    21
123  321
12344321

* */

fun pattern9() {

    val limit = 4
    for (i in 1..limit) {
        var j = 1
        while (j <= i) {
           print(j)
            j++
        }

        val rem = 2*(limit - i)
        for (e in 1..rem)
            print(" ")

        j--
       while (j >= 1){
           print(j)
            j--
        }
        println()
    }
}


/*

1      1
12    21
123  321
12344321

* */

fun pattern10() {

    val limit = 4
    for (i in 1..limit) {
        var j = 1
        while (j <= i) {
           print(j)
            j++
        }

        val rem = 2*(limit - i)
        for (e in 1..rem)
            print(" ")

        j--
       while (j >= 1){
           print(j)
            j--
        }
        println()
    }
}
