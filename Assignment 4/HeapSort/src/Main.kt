import org.example.MinHeap
import kotlin.system.measureTimeMillis

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun heapSort(mutableList: MutableList<Int>): MutableList<Int> {
    var myHeap = MinHeap<Int>()
    var outList  = mutableListOf<Int>()
    for (i in mutableList){
        myHeap.insert(i,i.toDouble())
    }
    while (!myHeap.isEmpty()) {
        outList.add(myHeap.getMin()!!)
    }
    return outList
}


fun randomNumberList(length:Int): MutableList<Int>{
    val myRange = (1..length).toList().shuffled()
    return myRange.toMutableList()
}
fun benchmarkFunc(length: Int): Long {
    val myList: MutableList<Int> = randomNumberList(length)
    var sortedList: MutableList<Int>? = null
    val timeTaken = measureTimeMillis {

        sortedList = heapSort(myList)
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
}