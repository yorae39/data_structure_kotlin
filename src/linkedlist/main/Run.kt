package src.linkedlist.main

import src.linkedlist.api.LinkedList
import src.linkedlist.api.Node
import src.utils.example

fun main() {
    testFunctionLinkedList()
}

fun testFunctionLinkedList() {

    "creating and liking nodes" example {
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)

        node1.next = node2
        node2.next = node3

        println(node1)
    }

    "push" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println(list)
    }

    "fluent interface push" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)
    }

    "append" example {
        val list = LinkedList<Int>()
        list.append(3)
        list.append(2)
        list.append(1)
        println(list)
    }

    "inserting at a particular index" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before inserting list: $list")
        var middleNode = list.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = list.insert(-1 * i, middleNode)
        }
        println("After inserting in list: $list")
    }

    "pop" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before popping list: $list")
        val poppedValue = list.pop()
        println("After popping list: $list")
        println("Popped value: $poppedValue")
    }

    "removing the last node" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before removing last node: $list")
        val removedValue = list.removeLast()
        println("After removing last node: $list")
        println("Removed value: $removedValue")
    }

    "removing a node after a particular node" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before removing at particular index: $list")
        val index = 1
        val node  = list.nodeAt(index -1)!!
        val removedValue = list.removeAfter(node)
        println("After removing at index $index: $list")
        println("Removed value $removedValue")
    }

    "printing doubles" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        for (item in list) {
            println("Double: ${item * 2}")
        }
    }

    "removing elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        println(list)
        list.remove(1)
        println(list)
    }

    "retaining elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.retainAll(listOf(3,4,5))
        println(list)
    }

    "remove all elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.removeAll(listOf(3,4,5))
        println(list)
    }
}