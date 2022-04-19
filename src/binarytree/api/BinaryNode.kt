package src.binarytree.api

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T : Any>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = "",
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"// IMPRIME OS NODES SEM FILHOS
            } else {
                // IMPRIME O RAMO DIREITO
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        // IMPRIME O MEIO          // IMPRIME O RAMO ESQUERDO
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    override fun toString(): String = diagram(this)

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun serialize(node: BinaryNode<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull {
            list.add(it)
        }
        return list
    }

    private fun deserialize(list: MutableList<T?>): BinaryNode<T>? {
        for (index in 1 until list.size) {
            val rootValue = list.removeAt(index) ?: return null
            val root = BinaryNode(rootValue)

            root.leftChild = deserialize(list)
            root.rightChild = deserialize(list)

            return root
        }
        return null
    }

    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T>? {
        return deserialize(list.asReversed())
    }

    private fun traversePreOrderWithNull(visit: (T?) -> Unit) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit)
    }

}