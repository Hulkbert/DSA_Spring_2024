class binaryWriter {
    /**
     * Writes the specified bit to the output binary data.
     * @param x the `boolean` to write.
     */
    fun write(x: Boolean) {
        
    }

    /**
     * Writes the *r*-bit int to the output binary data.
     * @param x the `int` to write.
     * @param r the number of relevant bits in the char.
     * @throws IllegalArgumentException if `r` is not between 1 and 32.
     * @throws IllegalArgumentException if `x` is not between 0 and 2<sup>r</sup> - 1.
     */
    fun write(x: Int, r: Int) {}


    /**
     * @return the output as a byte array
     */
    fun toByteArray(): ByteArray {
        return out.toByteArray()
    }

    /**
     * @return the output as a sequence of bytes that represent a string of
     * 0's and 1's
     */
    fun toBinaryString():ByteArray? {}

}