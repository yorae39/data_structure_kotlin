package src.linkedlist.exercise

import src.linkedlist.api.LinkedList
import src.linkedlist.api.Node

fun main() {
    val list1 = LinkedList<Int>()
    list1.add(1)
    list1.add(2)
    list1.add(3)

    val list2 = LinkedList<Int>()
    list2.add(4)
    list2.add(5)
    list2.add(6)

    println(list1.mergeSorted(list2))
}

fun<T : Comparable<T>> LinkedList<T>.mergeSorted(
    otherList: LinkedList<T>
): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun<T : Comparable<T>> append(
    result: LinkedList<T>,
    node: Node<T>
): Node<T>? {
    result.append(node.value)
    return node.next
}