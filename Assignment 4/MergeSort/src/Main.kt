//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.system.measureTimeMillis
fun merge(u: MutableList<Int>, v: MutableList<Int>): List<Int> {
    if(u.isEmpty() ){return v}
    if(v.isEmpty() ){return u}
    if(u[0]<v[0]){
        return mutableListOf(u[0])+merge(u.slice(1..<u.size,).toMutableList(),v)
    }
    else{
        return mutableListOf(v[0])+merge(u,v.slice(1..<v.size,).toMutableList())
    }


}
fun mergeSort(array: MutableList<Int>): MutableList<Int> {
    if (array.size <2){return array}
    val left: MutableList<Int> = mutableListOf()
    val right: MutableList<Int> = mutableListOf()
    for (i in 0..< array.size){
        if(i<array.size/2){
            left.add(array[i])
        }
        else {
            right.add(array[i])
        }
    }
    val leftSorted : MutableList<Int> = mergeSort(left)
    val rightSorted : MutableList<Int> = mergeSort(right)
    return merge(leftSorted,rightSorted).toMutableList()
}

fun randomNumberList(length:Int): MutableList<Int>{
    val myRange = (1..length).toList().shuffled()
    return myRange.toMutableList()
}
fun benchmarkFunc(length: Int): Long{
    val myList: MutableList<Int> = randomNumberList(length)
    var sortedList:MutableList<Int>? = null
    val timeTaken = measureTimeMillis {

        sortedList = mergeSort(myList)
    }
    return timeTaken
}

fun main() {
    var timeTaken = benchmarkFunc(50)
    println("Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(250)
    println("Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(500)
    println("Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(1000)
    println("Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(2000)
    println("Function took $timeTaken ms to run")
    timeTaken = benchmarkFunc(3000)
    println("Function took $timeTaken ms to run")
}
