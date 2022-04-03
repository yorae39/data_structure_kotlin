package src.queue.api

class RingBuffer<T : Any>(private val size: Int) {

    private var array = ArrayList<T?>(size)
    private var readIndex = 0
    private var writeIndex = 0

    val count: Int
        get() = availableSpaceForReading

    private val availableSpaceForReading: Int
        get() = (writeIndex - readIndex)

    val first: T?
        get() = array.getOrNull(readIndex)

    private val isEmpty: Boolean
        get() = (count == 0)

    private val availableSpaceForWriting: Int
        get() = (size - availableSpaceForReading)

    private val isFull: Boolean
        get() = (availableSpaceForWriting == 0)

    fun write(element: T): Boolean {
        return if (!isFull) {
            if (array.size < size) {
                array.add(element)
            } else {
                array[writeIndex % size] = element
            }
            writeIndex++
            true
        } else {
            false
        }
    }

    fun read(): T? {
        return if(!isEmpty) {
            val element = array[readIndex % size]
            readIndex++
            element
        } else {
            null
        }
    }

    override fun toString(): String {
        val values = (0 until availableSpaceForReading).map { offset ->
            "${array[(readIndex + offset) % size]!!}"
        }
        return values.joinToString(prefix = "[", separator = ",", postfix = "]")
    }
}