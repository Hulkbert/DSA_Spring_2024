class RedBlackTree<T: Comparable<T>> {
    var root=NodeClass(null,null,null,false,null)
    fun insert(value: T){
        if(value > root.value!!){

        }
    }
}
class NodeClass<T: Comparable<T>>(var rightNode: NodeClass<T>?,var leftNode: NodeClass<T>?,var parent: NodeClass<T>?,var color: Boolean,var value: T?){

}
