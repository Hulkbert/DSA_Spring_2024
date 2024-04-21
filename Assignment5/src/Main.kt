//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val g1="GATTACA"
    val g2="GCATGCG"
    println(needlemanWunschAlgorithm(g1,g2))
}
fun needlemanWunschAlgorithm(g1:String,g2:String):Pair<String,String> {
    val numRows = g1.length+1
    val numCols= g2.length+1
    var currentRow=numRows-1
    var currentCol=numCols-1
    var newG1=""
    var newG2=""


    var pointList = MutableList(numRows, { MutableList(numCols,{0}) })

    var arrowList = MutableList(numRows, { MutableList(numCols,{0}) })
    for (k in 0..<numRows){
        pointList[k][0]=-k
        arrowList[k][0]=3
    }
    for (l in 0..<numCols){
        pointList[0][l]=-l
        arrowList[0][l]=2
    }
    for(i in 1..<numRows){
        for(j in 1..<numCols){
            if(g1[i-1]==g2[j-1]){
                pointList[i][j]=pointList[i-1][j-1]+1
                arrowList[i][j]=1
            }
            else{
                var p1 = pointList[i-1][j-1]
                var p3 = pointList[i-1][j]
                var p2 = pointList[i][j-1]

                if(p1>p2 && p1>p3){
                    pointList[i][j]=p1-1
                    arrowList[i][j]=1
                }
                else if(p2>p1 && p2>p3){
                    pointList[i][j]=p2-1
                    arrowList[i][j]=2
                }
                else{
                    pointList[i][j]=p3-1
                    arrowList[i][j]=3
                }
            }
        }
    }
    while (currentCol !=0 && currentRow!= 0){

        if(arrowList[currentRow][currentCol]==1){
            newG1+=g1[currentRow-1]
            newG2+=g2[currentCol-1]
            currentCol--
            currentRow--
        }
        else if(arrowList[currentRow][currentCol]==2){
            newG1+="-"
            newG2+=g2[currentCol-1]
            currentCol--

        }
        else{
            newG1+=g1[currentRow-1]
            newG2+="-"

            currentRow--
        }
    }
    return Pair(newG1.reversed(),newG2.reversed()
    )
}