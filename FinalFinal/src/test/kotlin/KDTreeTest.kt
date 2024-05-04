import org.example.KDTree
import org.example.WineSample
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

class KDTreeTest {
    private val tree = KDTree(355)

    @Test
    fun getRoot() {
        assertNull(tree.root)

        val node = KDTree.Node(WineSample("sample1", List(10) { Random.nextDouble() }))
        tree.root = node

        assertEquals(node, tree.root)
    }

    @Test
    fun setRoot() {
        val node: KDTree.Node = KDTree.Node(WineSample("sample1", List(10) { Random.nextDouble() }))
        tree.root = node

        assertEquals(node, tree.root)
    }

    @Test
    fun insert() {
        val spectrum = WineSample("sample1", List(10) { Random.nextDouble() })
        tree.insert(spectrum)
        assertNotNull(tree.root)
    }

    @Test
    fun nearestNeighbor() {
        val node: KDTree.Node = KDTree.Node(WineSample("sample1", List(10) { Random.nextDouble() } ))
        tree.root = node
        val input: WineSample = WineSample("input", List(10) { Random.nextDouble() })
        val result: WineSample? = tree.nearestNeighbor(input)
        assertNotNull(result)
    }

    @Test
    fun bruteForceMatch() {
        val input: WineSample = WineSample("input", List(10) { Random.nextDouble() })
        val testData = mutableListOf<WineSample>()
        testData.add(input)
        val result: WineSample? = tree.bruteForceMatch(input,testData)
        assertNotNull(result)
    }

    @Test
    fun getK() {
        assertEquals(355, tree.k)
    }

}