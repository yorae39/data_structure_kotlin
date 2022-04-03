package src.queue.exercise

import src.queue.api.LinkedListQueue
import src.queue.api.Queue
import src.utils.example

fun main() {
    nextPatient()
}

fun nextPatient() {

    "calling for the next patient with queue 1" example {
        val queue = LinkedListQueue<Patient>().apply {
            returnListOfPatients().forEach{
                enqueue(it)
            }
        }
        println("Initial queue: $queue")
        println()
        while (!queue.isEmpty) {
            println("Wait your turn...")
            Thread.sleep(3000)
            println("\tNext patient: ${queue.nextPatient()}")
        }
        println()
        println("All patients attended")

    }

    "calling for the next patient with queue 2" example {
        val queue = LinkedListQueue<Patient>().apply {
            returnListOfPatients().forEach {
                enqueue(it)
            }
        }
        println("Initial queue: $queue")
        println()
        while (!queue.isEmpty) {
            println("Wait your turn...")
            Thread.sleep(3000)
            println("\tNext patient: ${queue.peek()}")
            queue.dequeue()
        }
        println()
        println("All patients attended")
    }
}

private fun returnListOfPatients(): List<Patient> {
    val pat1 = Patient("Luiz Paulo")
    val pat2 = Patient("Andréa")
    val pat3 = Patient("Bernardo")
    val list = ArrayList<Patient>()
    list.add(pat1)
    list.add(pat2)
    list.add(pat3)
    return list
}

private fun <T : Any> Queue<T>.nextPatient(): T? {
    return dequeue()
}

class Patient(
    private val name: String,
) {
    override fun toString(): String {
        return name
    }
}