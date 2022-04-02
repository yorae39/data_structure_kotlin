package src.linkedlist.exercise

import src.linkedlist.api.LinkedList
import src.linkedlist.api.Node

fun main() {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    println("Normal list: $list")
    println("Calling reversion method: ${list.reversed()}")
}

fun<T : Any> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

fun <T: Any> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}

