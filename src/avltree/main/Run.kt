package src.avltree.main

import src.avltree.api.AVLTree
import src.utils.example

fun main() {
 testAVLTree()
}

fun testAVLTree() {

    "removing a value" example {
        val tree = AVLTree<Int>()
        tree.insert(15)
        tree.insert(10)
        tree.insert(16)
        tree.insert(18)
        println(tree)
        println(tree.contains(10))
        tree.remove(10)
        println(tree)
        println(tree.contains(10))
    }
}