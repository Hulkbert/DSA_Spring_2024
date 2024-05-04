package org.example

import java.io.File
import kotlin.math.sqrt

/**
 * KDTree class represents a k-dimensional tree data structure.
 *
 * @property k The number of dimensions in the tree.
 * @property root The root node of the tree.
 * @constructor Creates a KDTree with the given number of dimensions.
 */
class KDTree(val k: Int) {
    var root: Node? = null

    /**
     * Represents a node in a binary tree.
     *
     * @param spectrum The wine sample associated with the node.
     * @param left The left child node.
     * @param right The right child node.
     */
    data class Node(val spectrum: WineSample, var left: Node? = null, var right:Node? = null)

    /**
     * Inserts a WineSample into a binary search tree.
     *
     * @param spectrum the WineSample to be inserted into the tree.
     * @param depth the current depth of the recursion.
     */
    fun insert(spectrum: WineSample, depth: Int = 0){
        root = insertRecursion(root,spectrum, depth)
    }

    /**
     * Inserts a WineSample into a binary search tree recursively.
     *
     * @param node the root node of the binary search tree (or subtree).
     * @param spectrum the WineSample to be inserted into the tree.
     * @param depth the current depth of the recursion.
     * @return the root node of the updated binary search tree (or subtree).
     */
    private fun insertRecursion(node: Node?, spectrum: WineSample, depth: Int): Node? {
        if (node == null) return Node(spectrum)
        val axis = depth % k
        if (spectrum.features[axis] < node.spectrum.features[axis]) {
            node.left = insertRecursion(node.left, spectrum, depth + 1)
        } else {
            node.right = insertRecursion(node.right, spectrum, depth + 1)
        }
        return node
    }
    /**
     * Finds the nearest neighbor to a given wine sample in the KDTree.
     *
     * @param input The wine sample to find the nearest neighbor for.
     * @param inputDepth The depth of the current node in the tree (default: 0).
     * @param best The current best node with minimum distance (default: null).
     * @return The wine sample that is the nearest neighbor to the input wine sample, or null if the tree is empty.
     */
    fun nearestNeighbor(input: WineSample, inputDepth: Int = 0, best: Node? = null): WineSample?{
        if (root == null) return null
        var topChoice = best ?: root
        var node = root
        var nextNode: Node?
        var compareNode: Node?
        var depth = inputDepth
        var axis =depth % k

        while (node!=null){
            if(input.features[axis]< node.spectrum.features[axis]){
                nextNode = node.left
                compareNode = node.right
            }
            else{
                nextNode = node.right
                compareNode = node.left
            }

            topChoice = storeDist(input, topChoice!!,node)

            if(nextNode != null){
                node = nextNode
                depth++
            }
            else {
                node = compareNode
            }
        }
        return topChoice?.spectrum
    }
    /**
     * Calculates the Euclidean distance between two vectors.
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     * @return The Euclidean distance between the two vectors.
     */
//Dist func done with copilot
    private fun distance(v1: List<Double>, v2: List<Double>): Double {
        return sqrt(v1.zip(v2).sumOf { (x, y) -> (x - y) * (x - y) })
    }
    /**
     * Stores the node with the minimum distance from the input wine sample.
     *
     * @param input The wine sample to compare distances with.
     * @param top The current top node with minimum distance.
     * @param node The node to compare distances with.
     * @return The node with the minimum distance from the input wine sample.
     */
    private fun storeDist(input: WineSample, top: Node, node: Node): Node{
        val topDist = distance(input.features,top.spectrum.features)
        val nodeDist = distance(input.features,node.spectrum.features)
        if(nodeDist<topDist){
            return node
        }
        else{
            return top
        }

    }



    /*
    fun printTree(){
        //ai gen for testing
        fun printTreeRecursion(node: Node?) {
            if (node != null) {
                printTreeRecursion(node.left)
                println(node.spectrum)
                printTreeRecursion(node.right)
            }
        }
        printTreeRecursion(root)
    }
    fun visualizeTree(): String {
        //ai gen
        fun visualizeTreeRecursion(node: Node?, depth: Int = 0): String {
            if (node == null) return ""
            val leftStr = visualizeTreeRecursion(node.left, depth + 1)
            val rightStr = visualizeTreeRecursion(node.right, depth + 1)
            return "${" ".repeat(depth)}${node.spectrum}\n$leftStr$rightStr"
        }
        return visualizeTreeRecursion(root)
    }

     */
    //more AI stuff for visualization

    /**
     * Export the binary tree as a DOT language string.
     *
     * @param node The root node of the tree to export.
     * @param depth The depth of the current node in the tree (default: 0).
     * @return A string representation of the binary tree in DOT language format.
     */
    private fun exportDot(node: Node?, depth: Int = 0): String {
        node ?: return ""
        val sb = StringBuilder()
        node.left?.let { sb.append("\"${node.spectrum.sampleId}-${depth}\" -> \"${it.spectrum.sampleId}-${depth+1}\" [label=\"L\"];\n${exportDot(it, depth + 1)}") }
        node.right?.let { sb.append("\"${node.spectrum.sampleId}-${depth}\" -> \"${it.spectrum.sampleId}-${depth+1}\" [label=\"R\"];\n${exportDot(it, depth + 1)}") }
        return sb.toString()
    }

    /**
     * Generates a DOT file for visualization of a binary tree structure.
     *
     * @param root The root node of the binary tree.
     * @param filepath The path to the file where the DOT graph will be saved.
     */
    fun generateDotFile(root: Node?, filepath: String) {
        val dotGraph = StringBuilder()
        dotGraph.append("digraph KDTree {\n")
        dotGraph.append(exportDot(root))
        dotGraph.append("}")
        File(filepath).writeText(dotGraph.toString())
    }

    /**
     * Finds the closest wine spectrum to a target wine sample using brute force matching.
     *
     * @param target The target wine sample.
     * @param spectra The list of wine samples to search from.
     * @return The closest wine spectrum to the target wine sample, or null if the list is empty.
     */
//AI fun
    fun bruteForceMatch(target: WineSample, spectra: List<WineSample>): WineSample? {
        if (spectra.isEmpty()) return null

        var closestSpectrum: WineSample? = null
        var minDistance = Double.MAX_VALUE

        spectra.forEach { spectrum ->
            val currentDistance = distance(target.features, spectrum.features)
            if (currentDistance < minDistance) {
                minDistance = currentDistance
                closestSpectrum = spectrum
            }
        }

        return closestSpectrum
    }


}