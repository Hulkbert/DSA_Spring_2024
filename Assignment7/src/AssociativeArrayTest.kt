import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AssociativeArrayTest {

    private lateinit var associativeArray: AssociativeArray<String, Int>

    @BeforeEach
    fun setUp() {
        associativeArray = AssociativeArray()
    }

    @Test
    fun testSet() {
        associativeArray["Key"] = 1
        assertEquals(1, associativeArray.size())
        assertEquals(1, associativeArray["Key"])
    }

    @Test
    fun testContains() {
        assertFalse(associativeArray.contains("Key"))
        associativeArray["Key"] = 1
        assertTrue(associativeArray.contains("Key"))
    }

    @Test
    fun testGet() {
        assertNull(associativeArray["Key"])
        associativeArray["Key"] = 1
        assertEquals(1, associativeArray["Key"])
    }

    @Test
    fun testRemove() {
        associativeArray["Key"] = 1
        assertTrue(associativeArray.remove("Key"))
        assertEquals(0, associativeArray.size())
        assertFalse(associativeArray.contains("Key"))
    }

    @Test
    fun testSize() {
        assertEquals(0, associativeArray.size())
        associativeArray["Key1"] = 1
        associativeArray["Key2"] = 2
        assertEquals(2, associativeArray.size())
    }

    @Test
    fun testKeyValuePairs() {
        associativeArray["Key1"] = 1
        associativeArray["Key2"] = 2
        val kvPairs = associativeArray.keyValuePairs()
        assertEquals(2, kvPairs.size)
        assertTrue(kvPairs.contains(Pair("Key1", 1)))
        assertTrue(kvPairs.contains(Pair("Key2", 2)))
    }
}