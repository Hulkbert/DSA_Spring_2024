import kotlin.system.measureTimeMillis

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun swap(array: MutableList<Int>,index1: Int, index2: Int){
    var temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
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

fun randomNumberList(length:Int): MutableList<Int>{
    val myRange = (1..length).toList().shuffled()
    return myRange.toMutableList()
}
fun benchmarkFunc(length: Int): Long {
    val myList: MutableList<Int> = randomNumberList(length)
    val timeTaken = measureTimeMillis {

        quickSort(myList,0,myList.size-1)
    }
    return timeTaken
}
fun main() {
    var timeTaken = benchmarkFunc(50)
    println("50 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(250)
    println("250 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(500)
    println("500 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(1000)
    println("1000 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(2000)
    println("2000 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(3000)
    println("3000 item Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(100000)
    println("100000 item Function took $timeTaken ms to run")
}