package tictactoe

fun printTicTacToe(a:MutableList<MutableList<String>>){
    for(value in a.indices){
        if (value == 4 || value == 0) println(a[value].joinToString (""))
        else println(a[value].joinToString(" "))
    }
//    println(checkWinner(a))
}
val players = arrayOf("X","O")
val winningCoordinate = mutableListOf("111213","212223","313233","112131","122232","132333","112233","132231")
fun checkWinner(a:MutableList<MutableList<String>>):String {
    var winner = ""
    // first checking if the coordinates are possible
    val spaceNumber = arrayOf(0, 0, 0)
    for (rows in a) {
        for (value in rows) {
            when (value) {
                "X" -> spaceNumber[0] = spaceNumber[0] + 1
                "O" -> spaceNumber[1] = spaceNumber[1] + 1
                "_" -> spaceNumber[2] = spaceNumber[2] + 1
            }


        }

    }

    if (spaceNumber[0] - spaceNumber[1] >= 2 || spaceNumber[0] - spaceNumber[1] <= -2) {
        winner = "Impossible"
    }else {
    repeat(2) {
        for (value in winningCoordinate) {
            if (players[it] == a[changeToNumber(value[0])][changeToNumber(value[1])] &&
                players[it] == a[changeToNumber(value[2])][changeToNumber(value[3])] &&
                players[it] == a[changeToNumber(value[4])][changeToNumber(value[5])]
            ) {
                if (winner.isNotEmpty()) {
                    winner = "Impossible"
                    break
                } else {
                    winner = "wins"
                }

            }
        }
    }
    }
    if(winner==""){
        winner = if(spaceNumber[0]+spaceNumber[1]==9) "Draw" else "Game not finished"
    }
    return winner

}

fun changeToNumber(a:Char) = a.toString().toInt()
fun whosTurn (a:Int) = if(a==0 || a==2 || a==4 || a==6 || a==8 ) "X" else "O"
fun main() {
    // write your code here
    val ticTacToePositions = mutableListOf(
        mutableListOf("---------"),
        mutableListOf("|", "_", "_", "_", "|"),
        mutableListOf("|", "_", "_", "_", "|"),
        mutableListOf("|", "_", "_", "_", "|"),
        mutableListOf("---------"),
    )
    printTicTacToe(ticTacToePositions)
  Looop@for(step in 0..8){

        while (true) {

            val move = readln().split(" ")
            try {
                if (!move[0].toCharArray()[0].isDigit() && !move[1].toCharArray()[0].isDigit())
                    throw Exception("You should enter numbers!")
                else if (move[0].toInt() !in 0..3 && move[1].toInt() !in 1..3)
                    throw Exception("Coordinates should be from 1 to 3!")
                else if (ticTacToePositions[move[0].toInt()][move[1].toInt()] != "_") {

                    throw Exception("This cell is occupied! Choose another one!")
                } else {
                    ticTacToePositions[move[0].toInt()][move[1].toInt()] = whosTurn(step)
                    when(checkWinner(ticTacToePositions)){
                        "Draw" -> {
                            printTicTacToe(ticTacToePositions)
                            println("Draw")
                            break@Looop  }
                        "wins" -> {
                            printTicTacToe(ticTacToePositions)
                            println("${whosTurn(step)} wins")
                            break@Looop

                        }
                        "Game not finished" ->  break

                    }
                }

            } catch (e: Exception) {
                println(e.message)
            }

        }
        printTicTacToe(ticTacToePositions)
        }

}


