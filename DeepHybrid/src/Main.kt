import kotlin.system.measureTimeMillis
import kotlin.random.Random

fun main() {
    val lengths = listOf(100,1000, 10000, 100000)

    for (length in lengths) {
        var testList = generateRandomNumbers(length)
        val insTime = measureTimeMillis { insertionSort(testList, 0, testList.size - 1) }
        println("Insertion Sort Time for $length elements time taken(ms): $insTime")

        testList = generateRandomNumbers(length)
        val quickTime = measureTimeMillis { quickSort(testList, 0, testList.size - 1) }
        println("Quick Sort Time for $length elements time taken(ms): $quickTime")

        testList = generateRandomNumbers(length)
        val hybridTime = measureTimeMillis { hybridSort(testList, 0, testList.size - 1) }
        println("Hybrid Quick/Insertion Sort Time for $length elements time taken(ms): $hybridTime")
    }
}

/**
 * Sorts a sublist of integers using the insertion sort algorithm.
 *
 * The insertion sort algorithm works by taking each element from the sublist and inserting it into its correct position
 * in the sorted part of the sublist. It iterates over the sublist, starting from the left index + 1 up to the right index.
 * For each element, it compares it with the previous elements in the sublist and shifts any elements that are greater
 * to the right. Finally, it inserts the current element in its correct position. This process continues until the entire
 * sublist is sorted.
 *
 * @param myList the mutable list of integers to be sorted
 * @param left the starting index of the sublist to be sorted
 * @param right the ending index of the sublist to be sorted
 */
fun insertionSort(myList: MutableList<Int>, left: Int, right: Int) {
    for (i in left + 1..right) {
        val post = myList[i]
        var j = i - 1

        while (j >= left && myList[j] > post) {
            myList[j + 1] = myList[j]
            j -= 1
        }
        myList[j + 1] = post
    }
}

fun swap(array: MutableList<Int>, index1: Int, index2: Int) {
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}



/**
 * Sorts a given sublist of integers using the hybrid sort algorithm.
 *
 * The hybrid sort algorithm combines the insertion sort and quick sort algorithms. It first checks if the size of the
 * sublist is less than the given threshold. If it is, it uses the insertion sort algorithm to sort the sublist.
 * Otherwise, it partitions the sublist using the quick sort algorithm and recursively applies the hybrid sort algorithm
 * to the two resulting partitions.
 *
 * @param array the mutable list of integers to be sorted
 * @param min the starting index of the sublist to be sorted
 * @param max the ending index of the sublist to be sorted
 * @param threshold the maximum size of the sublist to be sorted using the insertion sort algorithm
 */
fun hybridSort(array: MutableList<Int>, min: Int, max: Int, threshold: Int = 5) {
    if (min < max) {
        if (max - min < threshold) {
            insertionSort(array, min, max)
        } else {
            val pivotIndex = partition(array, min, max)
            hybridSort(array, min, pivotIndex - 1, threshold)
            hybridSort(array, pivotIndex + 1, max, threshold)
        }
    }
}

/**
 * Partitions a given sublist of integers based on a pivot element.
 *
 * @param array the mutable list of integers to be partitioned
 * @param min the starting index of the sublist to be partitioned
 * @param max the ending index of the sublist to be partitioned
 * @return the index of the pivot element after partitioning
 */
fun partition(array: MutableList<Int>, min: Int, max: Int): Int {
    val pivot = array[max]
    var i = min - 1
    for (j in min until max) {
        if (array[j] <= pivot) {
            i++
            swap(array, i, j)
        }
    }
    swap(array, i + 1, max)
    return i + 1
}

fun quickSort(array: MutableList<Int>,min: Int,max: Int){
    var pivot = array[min]
    var storeIndex = min+1
    if (max-min < 2){
        return
    }
    for (i in min+1 until max){
        if (array[i] < pivot){
            swap(array,i,storeIndex)
            storeIndex++
        }
    }
    swap(array,min,storeIndex-1)
    quickSort(array,min,storeIndex-1)
    quickSort(array,storeIndex,max)

}

fun generateRandomNumbers(size: Int): MutableList<Int> {
    return MutableList(size) { Random.nextInt(0, 999) }
}