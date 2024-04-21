class Matrix(private var size:Int) {
    private var array = Array(size, { IntArray(size) })
    fun readMatrix(row:Int,column: Int):Int{
        return this.array[row][column]
    }
    fun writeMatrix(row:Int,column: Int,input: Int){
        this.array[row][column]=input
    }
    operator fun plus(other: Matrix):Matrix{
        var matrix=Matrix(this.size)
        for(i in 0..<this.size){
            for(j in 0 ..<this.size){
                matrix.writeMatrix(i,j,this.readMatrix(i,j) + other.readMatrix(i,j))
            }
        }
        return matrix
    }
    operator fun minus(other: Matrix):Matrix{
        var matrix=Matrix(this.size)
        for(i in 0..<this.size){
            for(j in 0 ..<this.size){
                matrix.writeMatrix(i,j,this.readMatrix(i,j) - other.readMatrix(i,j))
            }
        }
        return matrix

    }
    operator fun times(scale: Int):Matrix{
        var matrix=Matrix(this.size)
        for(i in 0..<this.size){
            for(j in 0 ..<this.size){
                matrix.writeMatrix(i,j,this.readMatrix(i,j) * scale)
            }
        }
        return matrix

    }

    operator fun times(other: Matrix):Matrix{
        var matrix=Matrix(this.size)
        for(i in 0..<this.size){
            for(j in 0 ..<this.size){
                for(k in 0..<this.size){
                    matrix.writeMatrix(i,j,matrix.readMatrix(i,j)+this.readMatrix(i,k)*other.readMatrix(k,j))
                }
            }
        }
        return matrix

    }

    fun strassenMult(other: Matrix):Matrix{
        if (this.size < 2){
            return this*other
        }
        var matrix= Matrix(this.size)
        var a11 = Matrix(this.size/2)
        var a12 = Matrix(this.size/2)
        var a21 = Matrix(this.size/2)
        var a22 = Matrix(this.size/2)
        var b11 = Matrix(this.size/2)
        var b12 = Matrix(this.size/2)
        var b21 = Matrix(this.size/2)
        var b22 = Matrix(this.size/2)
        for(i in 0..<this.size/2){
            for(j in 0..<this.size/2){
                a11.writeMatrix(i,j,this.readMatrix(i,j))
                b11.writeMatrix(i,j,other.readMatrix(i,j))
            }
        }
        for(i in 0..<this.size/2){
            for(j in this.size/2..<this.size){
                a12.writeMatrix(i,j-size/2,this.readMatrix(i,j))
                b12.writeMatrix(i,j-size/2,other.readMatrix(i,j))
            }
        }
        for(i in this.size/2..<this.size){
            for(j in 0..<this.size/2){
                a21.writeMatrix(i-this.size/2,j,this.readMatrix(i,j))
                b21.writeMatrix(i-this.size/2,j,other.readMatrix(i,j))
            }
        }
        for(i in this.size/2..<this.size){
            for(j in this.size/2..<this.size){
                a22.writeMatrix(i-this.size/2,j-this.size/2,this.readMatrix(i,j))
                b22.writeMatrix(i-this.size/2,j-this.size/2,other.readMatrix(i,j))
            }
        }
        var M1=(a11+a22).strassenMult(b11+b22)
        var M2=(a21+a22).strassenMult(b11)
        var M3 = a11.strassenMult(b12-b22)
        var M4 = a22.strassenMult(b21-b11)
        var M5 = (a11+a12).strassenMult(b22)
        var M6 = (a21-a11).strassenMult(b11+b12)
        var M7 = (a12-a22).strassenMult(b21+b22)
        var c11 = M1+M4-M5+M7
        var c12 = M3+M5
        var c21=M2+M4
        var c22 = M1-M2+M3+M6

        for(i in 0..<this.size/2){
            for(j in 0..<this.size/2){
                matrix.writeMatrix(i,j,c11.readMatrix(i,j))
            }
        }
        for(i in 0..<this.size/2){
            for(j in this.size/2..<this.size){
                matrix.writeMatrix(i,j,c12.readMatrix(i,j-size/2))
            }
        }
        for(i in this.size/2..<this.size){
            for(j in 0..<this.size/2){
                matrix.writeMatrix(i,j,c21.readMatrix(i-this.size/2,j))
            }
        }
        for(i in this.size/2..<this.size){
            for(j in this.size/2..<this.size){
                matrix.writeMatrix(i,j,c22.readMatrix(i-this.size/2,j-this.size/2))
            }
        }
        return matrix
    }


}