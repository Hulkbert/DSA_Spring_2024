import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

fun main() {
    csvReader().open("src/main/resources/test.csv") {
        readAllAsSequence().forEach { row ->
            //Do something
            println(row) //[a, b, c]
        }
    }
}