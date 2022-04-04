package src.tree.exercise

import src.queue.api.ArrayListQueue

class TreeNodeExe<T>(val value: T) {
    private val children: MutableList<TreeNodeExe<T>> = mutableListOf()

    fun add(child: TreeNodeExe<T>) = children.add(child)

    fun printLevelOrder() {
        val queue = ArrayListQueue<TreeNodeExe<T>>()
        var nodesLeftInCurrentLevel: Int

        queue.enqueue(this) // PEGA OS NODE'S E COLOCA NA PILHA
        while (queue.isEmpty.not()) {   // ITERA NA PILHA ENQUANTO HOUVER VALOR
            nodesLeftInCurrentLevel = queue.count // ATRIBUI VALOR AO CONTADOR

            while (nodesLeftInCurrentLevel > 0) { // ITERA ENQUANTO O CONTADOR NÃO FOR ZERADO
                val node = queue.dequeue() // RETIRA O NODE DA PILHA EM ORDEM
                node?.let {
                    print("\t${node.value}") // SE O NODE TIVER VALOR IMPRIME O VALOR CORRESPONDENTE - [ NIVEIS ] PAIS E DEPOIS FILHOS [ FOLHAS ]
                    node.children.forEach { queue.enqueue(it) } // ITERA PARA RESGATAR OS FILHOS DOS NODES PRINCIPAIS
                    nodesLeftInCurrentLevel-- // DECREMENTA O CONTADOR
                } ?: break
            }
            println()
        }
    }
}