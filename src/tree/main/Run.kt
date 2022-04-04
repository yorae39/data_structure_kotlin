package src.tree.main

import src.tree.api.TreeNode

fun main() {

    testTree()
}

fun testTree() {
    val tree = makeBeverageTree()

    //tree.forEachDepthFirst { println(it.value) }
    //println()
    //tree.forEachLevelOrder { println(it.value) }

    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }

    tree.search("coca-cola")?.let {
        println(it.value)
    } ?: println("Couldn't find coca-cola")

}

private fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("chocolate")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return  tree
}