//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
data class WineSample(val sampleId: String, val features: List<Double>)
fun main() {

}
fun loadDataSet (filePath: String):List<WineSample>{
    val data = csvReader().readAllWithHeader(File(filePath))
    val sampleIds = data[0].keys.filter { it != "Wavenumbers" }
    val spectra = sampleIds.map { sampleId -> WineSample(sampleId, mutableListOf()) }
    return spectra
}
