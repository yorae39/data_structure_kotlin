package src.queue.api

class DoublyLinkedList<T : Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun isEmpty(): Boolean{
        return head == null
    }

    fun append(value: T) {
        val newNode = Node(value = value, previous = tail)
        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }
        tail?.next = newNode
        tail = newNode
    }

    fun node(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun remove(node: Node<T>): T {
        val prev = node.previous
        val next = node.next

        if (prev != null) {
            prev.next = node.previous
        } else {
            head = next
        }

        next?.previous = prev

        if (next == null) {
            tail = prev
        }

        node.previous = null
        node.next = null

        return node.value
    }

    val first: Node<T>?
        get() = head

    override fun toString(): String {
        return if (isEmpty()){
            "Empty list"
        } else {
            head.toString()
        }
    }
}