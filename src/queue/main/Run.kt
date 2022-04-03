package src.queue.main

import src.queue.api.ArrayListQueue
import src.queue.api.LinkedListQueue
import src.queue.api.RingBufferQueue
import src.queue.api.StackQueue
import src.utils.example

fun main() {
    testQueueAndRingBuffer()
}

fun testQueueAndRingBuffer() {

    "queue with arraylist" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Luiz Paulo")
            enqueue("Andréa")
            enqueue("Bernardo")
            enqueue("Sophia")
            enqueue("Alice")
        }

        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "queue with doubly linked list" example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Luiz Paulo")
            enqueue("Andréa")
            enqueue("Bernardo")
            enqueue("Sophia")
            enqueue("Alice")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "queue with ring buffer" example {
        val queue = RingBufferQueue<String>(10).apply {
            enqueue("Luiz Paulo")
            enqueue("Andréa")
            enqueue("Bernardo")
            enqueue("Sophia")
            enqueue("Alice")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "queue with double stack" example {
        val queue = StackQueue<String>().apply {
            enqueue("Luiz Paulo")
            enqueue("Andréa")
            enqueue("Bernardo")
            enqueue("Sophia")
            enqueue("Alice")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }
}