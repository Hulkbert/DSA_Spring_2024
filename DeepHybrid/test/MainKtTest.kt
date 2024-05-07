import org.junit.jupiter.api.Assertions.*

class MainKtTest {
    private var testList = generateRandomNumbers(10000)
    private var testListQ = testList


    @org.junit.jupiter.api.Test
    fun insertionSort() {
        insertionSort(testList,0,testList.size-1)
        assert(testList == testList.sorted())
    }

    @org.junit.jupiter.api.Test
    fun quickSort() {
//        println(testListQ)
//        quickSort(testListQ, 0, testListQ.size - 1)
//        println(testListQ)
//        println(testList.sorted())
        quickSort(testListQ,0,testListQ.size-1)
        assert(testListQ == testListQ.sorted())

    }
}