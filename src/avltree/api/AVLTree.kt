package src.avltree.api

import kotlin.math.max

class AVLTree<T : Comparable<T>> {

    private var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    override fun toString() = root?.toString() ?: "empty tree"

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value)
        if(value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        val balanceNode = balanced(node)

        balanceNode.height = max(balanceNode.leftHeight, balanceNode.rightHeight) + 1

        return balanceNode
    }

    private fun remove(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                // 1
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }
                // 2
                if (node.leftChild == null) {
                    return node.rightChild
                }
                // 3
                if (node.rightChild == null) {
                    return node.leftChild
                }
                // 4
                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }

        val balancedNode = balanced(node)
        balancedNode.height = max(
            balancedNode.leftHeight,
            balancedNode.rightHeight
        ) + 1

        return balancedNode
    }

    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if(node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }
            -2 -> {
                if(node.rightChild?.balanceFactor == 1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }
            else -> node
        }
    }

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }


    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

}