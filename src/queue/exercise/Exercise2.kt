package src.queue.exercise

import src.queue.api.LinkedListQueue
import src.queue.api.Queue
import src.stack.api.StackImpl
import src.utils.example

fun main() {
    reversedQueue()
}

fun reversedQueue() {

    "Queue reversed" example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("LP")
            enqueue("Andrea")
            enqueue("Bernardo")
        }
        println("Before : $queue")
        queue.reverse()
        println("After  : $queue")
    }
}

private fun <T : Any> Queue<T>.reverse() {
    val aux = StackImpl<T>()
    var next = this.dequeue() // RETIRADNO COMPONENTES PARA ITERAÇÃO
    // ITERANDO NOS COMPONENTES DA FILA
    while (next != null) {
        aux.push(next) // ALOCANDO NO AUXILIAR PILHA [FIFO]
        next = this.dequeue() // REALIMENTANDO O ITERADOR
    }

    // RETIRANDO DO AUXILIAR E INICIALIZANDO A VARIAVEL
    next = aux.pop()
    // NOVA ITERAÇÃO
    while (next != null) {
        this.enqueue(next) // ALOCANDO NA FILA COM ORDEM DE PILHA [FIFO] E PORTANTO INVERSA
        next = aux.pop() // REALIMENTANDO O ITERADOR
    }

    /*
        RESUMO:
            1 - ITERAR - RETIRAR DA FILA E ALOCAR NA PILHA
            2 - ITERAR - RETIRAR DA PILHA E ALOCAR NA FILA
    */
}