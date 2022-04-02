package src.stack.exercise

import src.linkedlist.api.LinkedList
import src.stack.api.StackImpl

fun main() {
    val list = LinkedList<Int>()
    list.add(3)
    list.add(2)
    list.add(1)
    list.printReverse()
}

fun<T : Any> LinkedList<T>.printReverse() {
    val stack = StackImpl<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()

    while (node != null) {
        println(node)
        node = stack.pop()
    }
    
    /*for (i in 0..stack.count) {
        println(node)
        node = stack.pop()
    }*/
}