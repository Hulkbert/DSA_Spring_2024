//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File
fun main() {
    val data = File("C:\\Users\\amanrique\\Documents\\GitHub\\DSA_Spring_2024\\Assignment7\\src\\pg27253_cleaned.txt").readText()
    //val data = "I am Sam.\n\nI am Sam.\nSam I am."
    println(generateStatement(buildNextWords(buildWordList(data))))
}
/**
 * Builds a list of words from the provided string data.
 *
 * @param data the string data to build the word list from
 * @return the list of words
 */
fun buildWordList(data:String):List<String>{
    return data.split(" ","\n")
}
/**
 * Builds a mapping of words to their next possible words.
 *
 * @param wordList the list of words to build the mapping from
 * @return an associative array containing the mapping of words to their next possible words, words occuring...
 */
fun buildNextWords(wordList: List<String>):AssociativeArray<String,MutableList<String>>{
    var nextWords = AssociativeArray<String, MutableList<String>>()
    var currentWord: String? = null
    nextWords.set("", mutableListOf())
    for( i in 0..<wordList.size) {
        var word = wordList[i]
        if (currentWord == null) {
            nextWords[""]?.add(word)
        } else {
            if (currentWord!! !in nextWords) {
                nextWords[currentWord!!] = mutableListOf()
            }
            nextWords[currentWord!!]?.add(word)
        }
        if (word.endsWith(".") || word.endsWith("?") || word.endsWith("!")) {
            nextWords[word] = mutableListOf("")
            currentWord = null
        } else {
            currentWord = word
        }
    }
    return nextWords
}

/**
 * Generates a statement based on the provided associative array.
 *
 * @param nextWords the associative array containing the mapping of words to their next possible words
 * @return the generated statement
 */
fun generateStatement(nextWords: AssociativeArray<String, MutableList<String>>):String{
    var sentence = ""
    var word = ""
    while( nextWords[word] != listOf("")){
        val nextWord = nextWords[word]!!.random()
        sentence += "$nextWord "
        word = nextWord
    }
    return sentence.trim(' ')


}

