package src.binarytree.main

import src.binarytree.api.BinaryNode

fun main() {
    testBinaryTree()
}

fun testBinaryTree() {

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    val twentyFive = BinaryNode(25)
    val two = BinaryNode(2)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    eight.rightChild = two
    nine.leftChild = eight
    zero.leftChild = twentyFive

    //IMPRIME NODES EM ORDEM
    println(seven)

    val array = seven.serialize()
    // IMPRIME NODES EM ORDEM INVERSA
    println(seven.deserializeOptimized(array))

    // IMPRIME VALORES EM POS ORDEM
    seven.traversePostOrder { println(it) }

}