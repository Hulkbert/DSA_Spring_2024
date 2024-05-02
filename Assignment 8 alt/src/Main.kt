import javax.swing.tree.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution(nums: IntArray){
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        val midpoint = nums[nums.size/2]
        var root=NodeClass(null,null,null,midpoint)
        for(i in 0..<nums.size){
            //make shit

        }
        return TreeNode
    }
    fun recursNode(compNode: NodeClass<T>,currentVal: T?):NodeClass<T> {
        var newNode=NodeClass(null,null,null,currentVal)
        if(compNode.value<newNode.value){
            compNode.rightNode = recursNode(newNode.parentNode, currentVal)
            //if the compnode have no children then you're at hte bottom of the tree which means you can adda new node as one of the children and then if it has any children then you have to continue recursing with whatever child direction your're going in.
        }
    }
}


// Additional Node class for a binary search tree
class NodeClass<T: Comparable<T>>(
    var rightNode: NodeClass<T>?, var leftNode: NodeClass<T>?,
    var parentNode: NodeClass<T>?, var value: T){
    // initialization of the node class


}