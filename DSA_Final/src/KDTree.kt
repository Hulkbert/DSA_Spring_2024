data class TreeNode(
    val point: List<Double>,
    val label: String,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

class KDTree(val k: Int) {
    var root: TreeNode? = null

    fun insert(point: List<Double>, label: String) {
        root = insertRecursive(root, point, label, 0)
    }

    private fun insertRecursive(
        current: TreeNode?,
        point: List<Double>,
        label: String,
        depth: Int): TreeNode {
            if (current == null) {
                return TreeNode(point, label)
            }

            // Calculate current dimension
            val dimension = depth % k

            if (point[dimension] < current.point[dimension]) {
                current.left = insertRecursive(current.left, point, label, depth + 1)
            } else {
                current.right = insertRecursive(current.right, point, label, depth + 1)
            }

            return current
        }

    // Search function
    fun search(point: List<Double>): TreeNode? {
        return searchRecursive(root, point, 0)
    }

    private fun searchRecursive(current: TreeNode?, point: List<Double>, depth: Int): TreeNode? {
        // Tree is empty means node is not found
        current ?: return null

        // If point matches with root
        if (current.point == point) {
            return current
        }

        // Calculate current dimension
        val dimension = depth % k

        // Compare point with root
        return if (point[dimension] < current.point[dimension]) {
            searchRecursive(current.left, point, depth + 1)
        } else {
            searchRecursive(current.right, point, depth + 1)
        }
    }
}