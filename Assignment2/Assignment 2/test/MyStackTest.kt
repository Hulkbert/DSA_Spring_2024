import org.junit.jupiter.api.Assertions.*

class MyStackTest {

    @org.junit.jupiter.api.Test
    fun push() {
        val stack = MyStack<String>()
        stack.push("hello")
        stack.push("world")
        assertEquals(stack.peek(), "world")
    }

    @org.junit.jupiter.api.Test
    fun pop() {
        val stack = MyStack<String>()
        stack.push("world")
        val returnPop = stack.pop()
        assertEquals("world",returnPop)
    }

    @org.junit.jupiter.api.Test
    fun peek() {
        val stack = MyStack<String>()
        stack.push("world")
        assertEquals("world",stack.peek())
    }

    @org.junit.jupiter.api.Test
    fun isEmpty() {
        val stack = MyStack<String>()
        assertEquals(true,stack.isEmpty())
    }
}