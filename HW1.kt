/**
 * Functions that print the next number in a look and say sequence
 */

/**
 * Generates the next number in the look and say sequence
 *
 * inputs: lookAndSayNum the current numbers as a string
 * returns: newString the next numbers in the sequence as a string
 */
fun nextNumber(lookAndSayNum: String): String{
    var counter = 1
    val mid= lookAndSayNum.plus(other = " ")
    var newString = ""

    for(i in 0 until mid.length - 1){
        if (mid[i] == mid[i+1]) {
            counter++
        }else{
            newString += "$counter${mid[i]}"
            counter = 1

        }
    }

    return newString
}

/**
 * Runs the look and say sequence for an amount
 * Inputs: length , the length of the desired sequence in an int
 * returns: the iterated sequence of numbers up to the specified length
 */

fun look_and_say(length: Int) {
    var numCurrent= "1"
    for (i in 0 until length){
        println(numCurrent)
        numCurrent = nextNumber(numCurrent)
    }
}

/**
 * Examples and Unit tests
 */

fun main(){
    look_and_say(5)
}