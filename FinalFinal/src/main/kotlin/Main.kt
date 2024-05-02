package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import kotlin.system.measureTimeMillis

data class WineSample(val sampleId: String, val features: List<Double>)
fun main() {

    val dataSet=loadDataSet("C:/Users/amanrique/Documents/GitHub/DSA_Spring_2024/FinalFinal/src/main/kotlin/Wine_FTIR_Triplicate_Spectra.csv")
    val separatedData = splitData(dataSet)
    val trainingData = separatedData.first
    val testingData = separatedData.second //smaller data set, every 3rd sample
    val kdTree = KDTree(trainingData[1].features.size)
    trainingData.forEach{kdTree.insert(it)}
    val test1 =testingData[10]
    println("input" + test1.sampleId)


    val timeTakenKD = measureTimeMillis { kdTree.nearestNeighbor(test1) }
    val nearest1 = kdTree.nearestNeighbor(test1)


    println("kd tree" + nearest1!!.sampleId+ " time taken(ms): $timeTakenKD")
    val timeTakenBrute = measureTimeMillis { kdTree.bruteForceMatch(test1, trainingData) }


    val bruteForceMatch: WineSample? = kdTree.bruteForceMatch(test1, trainingData)
    println("brute force " + bruteForceMatch?.sampleId+ " time taken(ms): $timeTakenBrute")
    //kdTree.generateDotFile(kdTree.root,"visualize.dot")
}
fun loadDataSet (filePath: String):List<WineSample>{
    val data = csvReader().readAllWithHeader(File(filePath))
    val sampleIds = data[0].keys.filter { it != "Wavenumbers" }
    val spectra = sampleIds.map { sampleId -> WineSample(sampleId, mutableListOf()) }

    data.forEach {row ->
        val wavenumber=row["Wavenumbers"]!!
        sampleIds.forEachIndexed{
            index, sampleId -> (spectra[index].features as MutableList<Double>).add(row[sampleId]!!.toDouble())
        }
    }
    return spectra
}
fun splitData(spectra: List<WineSample>): Pair<List<WineSample>,List<WineSample>>{
    val training = mutableListOf<WineSample>()
    val testing = mutableListOf<WineSample>()

    spectra.forEachIndexed { index, spectrum ->
        if((index + 1)% 3 == 0){testing.add(spectrum)}
        else {training.add(spectrum)}

    }
    training.shuffle()
    return Pair(training,testing)
}




