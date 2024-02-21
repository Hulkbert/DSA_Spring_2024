import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MyQueueTest {

    @Test
    fun enqueue() {
        val queue = MyQueue<String>()
        queue.enqueue("hello")
        queue.enqueue("world")
        assertEquals(queue.peek(), "world")
    }

    @Test
    fun dequeue() {
        val queue = MyQueue<String>()
        queue.enqueue("hello")
        assertEquals("hello",queue.dequeue())
    }

    @Test
    fun peek() {
        val queue = MyQueue<String>()
        queue.enqueue("hello")
        assertEquals("hello",queue.peek())
    }

    @Test
    fun isEmpty() {
        val queue = MyQueue<String>()
        assertEquals(true,queue.isEmpty())
    }
}