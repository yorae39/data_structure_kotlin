package src.linkedlist.exercise

import src.linkedlist.api.LinkedList
import src.linkedlist.api.Node

fun main() {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.add(6)
    list.add(7)
    list.add(8)
    list.add(9)

    println("List: $list")
    list.printMiddleNodeAndValueNode()
    println("Middle Node2: ${list.getMiddle()}")
    println()
    // ---------------------------------------------
    val list2 = LinkedList<String>()
    list2.add("Andrea")
    list2.add("Luiz Paulo")
    list2.add("Bernardo")
    list2.add("Sophia")
    list2.add("Alice")

    println("List2: $list2")
    list2.printMiddleNodeAndValueNode()
    println("Middle Node2: ${list2.getMiddle()}")

}

fun<T : Any> LinkedList<T>.printMiddleNodeAndValueNode(){
    val middleNode = this.nodeAt(this.size/2)!!
    println("MiddleValue = ${middleNode.value}")
    println("Middle Node1: $middleNode")
}


fun<T : Any> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}