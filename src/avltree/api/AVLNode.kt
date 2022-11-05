package src.avltree.api

typealias Visitor<T> = (T) -> Unit
class AVLNode<T: Comparable<T>>(
    var value: T
) {

    var leftChild: AVLNode<T>?  = null
    var rightChild: AVLNode<T>? = null

    val min: AVLNode<T>
        get() = leftChild?.min ?: this

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

    private fun diagram(node: AVLNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    override fun toString(): String = diagram(this)

    fun traverseInOrder(visitor: Visitor<T>) {
        leftChild?.traverseInOrder(visitor)
        visitor(value)
        rightChild?.traverseInOrder(visitor)
    }

    fun traversePreOrder(visitor: Visitor<T>) {
        visitor(value)
        leftChild?.traversePreOrder(visitor)
        rightChild?.traversePreOrder(visitor)
    }

    fun traversePostOrder(visitor: Visitor<T>) {
        leftChild?.traversePostOrder(visitor)
        rightChild?.traversePostOrder(visitor)
        visitor(value)
    }
}