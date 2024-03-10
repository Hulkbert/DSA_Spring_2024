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
fun main() {
    var arrayMain = mutableListOf(1,4,3,2,5,6,8,7,9)
    quickSort(arrayMain,0,arrayMain.size)
    println(arrayMain)
}