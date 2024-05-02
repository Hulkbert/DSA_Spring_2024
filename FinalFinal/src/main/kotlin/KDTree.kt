package org.example

import java.io.File
import kotlin.math.sqrt

class KDTree(val k: Int) {
    var root: Node? = null

    data class Node(val spectrum: WineSample, var left: Node? = null, var right:Node? = null)

    fun insert(spectrum: WineSample, depth: Int = 0){
        root = insertRecursion(root,spectrum, depth)
    }

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
    //Dist func done with copilot
    private fun distance(v1: List<Double>, v2: List<Double>): Double {
        return sqrt(v1.zip(v2).sumOf { (x, y) -> (x - y) * (x - y) })
    }
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
    private fun exportDot(node: Node?, depth: Int = 0): String {
        node ?: return ""
        val sb = StringBuilder()
        node.left?.let { sb.append("\"${node.spectrum.sampleId}-${depth}\" -> \"${it.spectrum.sampleId}-${depth+1}\" [label=\"L\"];\n${exportDot(it, depth + 1)}") }
        node.right?.let { sb.append("\"${node.spectrum.sampleId}-${depth}\" -> \"${it.spectrum.sampleId}-${depth+1}\" [label=\"R\"];\n${exportDot(it, depth + 1)}") }
        return sb.toString()
    }

    fun generateDotFile(root: Node?, filepath: String) {
        val dotGraph = StringBuilder()
        dotGraph.append("digraph KDTree {\n")
        dotGraph.append(exportDot(root))
        dotGraph.append("}")
        File(filepath).writeText(dotGraph.toString())
    }

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