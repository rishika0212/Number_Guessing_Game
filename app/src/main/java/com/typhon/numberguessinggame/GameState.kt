package com.typhon.numberguessinggame

data class GameState(
    val userNumber:String = "",
    val guessesLeft:Int=5,
    val guessedNumbers:List<Int> = emptyList(),
    val mysteryNumber: Int=(1..99).random(),
    val hintDescription:String="Guess\nthe mystery number between\n0 and 100.",
    val gameStage: GameStage=GameStage.PLAYING
)

enum class GameStage{
    WON,
    LOSE,
    PLAYING
}
