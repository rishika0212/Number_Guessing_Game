package com.typhon.numberguessinggame

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel: ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    fun updateText(userNo:String){
        _state.update { it.copy(userNumber = userNo) }
    }
    fun resetGame() {
        _state.value = GameState()
    }

    fun onUserInput(
        userNumber: String,
        context: Context
        ){
        val userNumberInInt=try{
            userNumber.toInt()
        }catch(e:Exception){
            0
        }

        if (userNumberInInt !in 1..99){
            Toast.makeText(
                context,
                "Please enter a number between 0 and 100.",
                Toast.LENGTH_SHORT
            ).show()
            return

        }

        val currentState=state.value

        val newGuessLeft = currentState.guessesLeft-1

        val newGameStage = when{
            userNumberInInt==currentState.mysteryNumber-> GameStage.WON
            newGuessLeft==0-> GameStage.LOSE
            else -> GameStage.PLAYING
        }

        val newHintDescription= when {
            userNumberInInt>currentState.mysteryNumber->{
                "Hint\nYou are guessing a number that is bigger than the mystery number."
            }
            userNumberInInt<currentState.mysteryNumber->{
                "Hint\nYou are guessing a number that is smaller  than the mystery number."
            }

            else ->""
        }

        val newGuessNoList=currentState.guessedNumbers.plus(userNumberInInt)

        _state.update{
            it.copy(
                userNumber="",
                guessesLeft = newGuessLeft,
                guessedNumbers = newGuessNoList,
                hintDescription = newHintDescription,
                gameStage = newGameStage
            )
        }
    }
}