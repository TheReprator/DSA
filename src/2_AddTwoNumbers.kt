/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val first = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val second = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }
    val result = addTwoNumbers(first, second)
    println(result)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var head: ListNode ?= null

    var head1 = l1
    var head2 = l2

    var carrry = 0
    var temp: ListNode ?= null

    while ((head1 != null) || (head2 != null)) {

        var sum = carrry
        if(head1 != null) {
            sum += head1.`val`
            head1 = head1.next
        }

        if(head2 != null) {
            sum += head2.`val`
            head2 = head2.next
        }

        val node = ListNode(sum % 10)
        carrry = sum/10

        if(null == head) {
            head = node
            temp = head
        } else {
            temp?.next = node
            temp = temp?.next
        }
    }

    if(0 < carrry) {
        temp?.next = ListNode(carrry)
    }
    return head
}