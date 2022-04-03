package src.queue.api

class RingBufferQueue<T : Any>(size : Int) : Queue<T>  {

    private val ringBuffer = RingBuffer<T>(size)

    override val count: Int
        get() = ringBuffer.count

    override fun enqueue(element: T): Boolean = ringBuffer.write(element)

    override fun dequeue(): T? = if (isEmpty) null else ringBuffer.read()

    override fun peek(): T? = ringBuffer.first

    override fun toString(): String = ringBuffer.toString()
}