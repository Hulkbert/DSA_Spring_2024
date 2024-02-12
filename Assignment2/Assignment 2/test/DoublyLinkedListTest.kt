import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DoublyLinkedListTest {

    @Test
    fun pushFront() {
        val list = DoublyLinkedList<String>()
        list.pushFront("hello")
        list.pushFront("world")
        assertEquals(list.peekFront(), "world")
    }

    @Test
    fun pushBack() {
        val list = DoublyLinkedList<String>()
        list.pushBack("hello")
        list.pushBack("world")
        assertEquals(list.peekFront(), "world")
    }

    @Test
    fun popFront() {
        val list = DoublyLinkedList<String>()
        list.pushFront("world")
        val returnPop = list.popFront()
        assertEquals("world",returnPop)
    }

    @Test
    fun popBack() {
        val list = DoublyLinkedList<String>()
        list.pushFront("hello")
        assertEquals("hello",list.popBack())
    }

    @Test
    fun peekFront() {
        val list = DoublyLinkedList<String>()
        list.pushFront("world")
        assertEquals("world",list.peekFront())
    }

    @Test
    fun peekBack() {
        val list = DoublyLinkedList<String>()
        list.pushBack("hello")
        assertEquals("hello",list.peekBack())
    }

    @Test
    fun isEmpty() {
        val list = DoublyLinkedList<String>()
        assertEquals(true,list.isEmpty())
    }
}