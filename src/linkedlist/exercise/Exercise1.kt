package src.linkedlist.exercise

import src.linkedlist.api.LinkedList
import src.linkedlist.api.Node

fun main() {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.printInReverse()
    println()
    println(list)
}

fun <T : Any> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun<T: Any> Node<T>.printInReverse() {
    /*CHAMADA RECURSIVA QUE TROCA A POSIÇÃO DOS NODES*/
    this.next?.printInReverse()
    if (this.next != null) {
        print(" <- ")
    }
    print(this.value.toString())
}