import kotlin.math.abs

/**
 * Represents a mapping of keys to values.
 * @param K the type of the keys
 * @param V the type of the values
 */
class AssociativeArray<K, V> {
    var primeList = listOf(53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741)
    var primeCounter = 0
    var chonkyList = MutableList(primeList[primeCounter]) { mutableListOf<Pair<K, V>>() }


    /**
     * Enlarges the array if the current size is equal to or greater than the next prime number in the primeList.
     * It copies the existing key-value pairs to the newly enlarged array.
     */
    private fun enlargeArray(){
        if(this.size()>=primeList[primeCounter]){
            primeCounter++
            //keyValuePairs()
            var kvpList = this.keyValuePairs()
            chonkyList = MutableList(primeList[primeCounter]) { mutableListOf<Pair<K, V>>() }
            for (i in 0..< kvpList.size){
                this[kvpList[i].first] = kvpList[i].second
            }

        }

    }

    /**
     * Insert the mapping from the key, [k], to the value, [v].
     * If the key already maps to a value, replace the mapping.
     */
    operator fun set(k: K, v: V) {
        this.enlargeArray()
        var keyHash = abs(k.hashCode())%primeList[primeCounter]
        chonkyList[keyHash].add(Pair(k,v))

    }

    /**
     * @return true if [k] is a key in the associative array
     */
    operator fun contains(k: K): Boolean {
        //k.hashCode() find index in chonkyList
        val fullList=chonkyList[abs(k.hashCode())%primeList[primeCounter]]

        for (i in 0..<fullList.size) {
            if (fullList[i].first == k) {
                return true
            }
        }
        return false
    }

    /**
     * @return the value associated with the key [k] or null if it doesn't exist
     */
    operator fun get(k: K): V? {
        //k.hashCode() find index in chonkyList
        val fullList=chonkyList[abs(k.hashCode())%primeList[primeCounter]]

        for (i in 0..<fullList.size) {
            if (fullList[i].first == k) {
                return fullList[i].second
            }
        }
        return null
    }

    /**
     * Remove the key, [k], from the associative array
     * @param k the key to remove
     * @return true if the item was successfully removed and false if the element was not found
     */
    fun remove(k: K): Boolean {
        //k.hashCode() find index in chonkyList
        val fullList=chonkyList[abs(k.hashCode())%primeList[primeCounter]]

        for (i in 0..<fullList.size) {
            if (fullList[i].first == k) {
                fullList.removeAt(i)
                return true
            }
        }
        return false
    }


    /**
     * @return the number of elements stored in the hash table
     */
    fun size(): Int {
        var size = 0
        for(i in 0..<chonkyList.size){
            size += chonkyList[i].size
        }
        return size
    }

    /**
     * @return the full list of key value pairs for the associative array
     */
    fun keyValuePairs(): List<Pair<K, V>> {
        var totalValue = mutableListOf<Pair<K,V>>()
        for(i in 0..<chonkyList.size){
            totalValue.addAll(chonkyList[i])
        }
        return totalValue
    }
    /*
    make the resizing shit resize the shit and then make shit go brrrrr and then use the add function to add new shit to the old shit

     */
}
