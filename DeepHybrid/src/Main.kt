//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val testList = mutableListOf(24, 3, 45, 20, 56, 78, 1, 23, 26, 7, 8, 34, 65)


}

// ---------------------- Insertion Sort -------------------------

fun insertionSort(myList: MutableList<Int>, left: Int, right: Int): MutableList<Int> {
    var outList = myList.slice(left..right).toMutableList()
    for (i in 1..<outList.size) {
        val post = outList[i]
        var j = i - 1

        while (j >= 0 && outList[j] > post) {
            outList[j + 1] = outList[j]
            j -= 1
        }
        outList[j + 1] = post
    }
    return outList
}

// ---------------------- Quick Sort ------------------------------

fun swap(array: MutableList<Int>,index1: Int, index2: Int){
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun quickSort(array: MutableList<Int>,min: Int,max: Int, threshold: Int = 10){
    var pivot = array[min]
    var storeIndex = min+1
    if (max-min < threshold){
        insertionSort(array,min,max)
        return
    }else {
        for (i in min + 1 until max) {
            if (array[i] < pivot) {
                swap(array, i, storeIndex)
                storeIndex++
            }
        }
        swap(array, min, storeIndex - 1)
        quickSort(array, min, storeIndex - 1, threshold)
        quickSort(array, storeIndex, max, threshold)
    }
}