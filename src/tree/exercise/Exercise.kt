package src.tree.exercise

fun main() {
    testPrintTreeEachLevel()
}

fun testPrintTreeEachLevel() {
    val tree = makeTree()
    tree.printLevelOrder()
}

fun makeTree(): TreeNodeExe<Int> {
    // Raiz da árvore
    val tree = TreeNodeExe(15)

    // Segundo nível
    val one = TreeNodeExe(1)
    tree.add(one)

    val seventeen = TreeNodeExe(17)
    tree.add(seventeen)

    val twenty = TreeNodeExe(20)
    tree.add(twenty)

    // Terceiro nivel
    val one2 = TreeNodeExe(1)
    val five = TreeNodeExe(5)
    val zero = TreeNodeExe(0)
    one.add(one2)
    one.add(five)
    one.add(zero)

    val two = TreeNodeExe(2)
    seventeen.add(two)

    val five2 = TreeNodeExe(5)
    val seven = TreeNodeExe(7)
    twenty.add(five2)
    twenty.add(seven)

    return tree
}


