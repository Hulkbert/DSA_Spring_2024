import kotlin.system.measureTimeMillis

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun insertionSort(myList: MutableList<Int>): MutableList<Int>{
    var outList = mutableListOf<Int>()

    for (ele in myList){
        var idx = -1
        for (outIdx in 0 until outList.size){
            if (outList[outIdx] > ele){
                idx = outIdx
                break

            }


        }
        if (idx == -1){
            idx  = outList.size
        }
        outList.add(idx,ele)

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

        sortedList = insertionSort(myList)
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