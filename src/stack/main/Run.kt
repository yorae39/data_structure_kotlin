package src.stack.main

import src.stack.api.StackImpl
import src.stack.api.stackOf
import src.utils.example

fun main() {
    testStack()
}

fun testStack() {

    "using a stack" example {
        val stack = StackImpl<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
        }
        print(stack)
        val poppedElement = stack.pop()
        if (poppedElement != null) {
            println("Propped: $poppedElement")
        }
        print(stack)
    }

    "initializing a stack from  a list" example {
        val list = listOf("A", "B", "C", "D")
        val stack = StackImpl.create(list)
        print(stack)
        println("Propped: ${stack.pop()}")
    }

    "initializing a stack from a array literal" example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        print(stack)
        println("Propped: ${stack.pop()}")
    }
}