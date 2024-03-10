//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

    fun main() {
        val myList: MutableList<Int> = mutableListOf(83, 89, 55, 65, 30, 84, 60, 30, 31, 90)
        println(myList)
        println(mergeSort(myList))
    }