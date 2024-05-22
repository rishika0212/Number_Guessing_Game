package com.typhon.numberguessinggame

import com.typhon.numberguessinggame.ui.theme.Maroon
import com.typhon.numberguessinggame.ui.theme.lavender

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.typhon.numberguessinggame.R

@Composable
fun WinOrLoseDialog(
    text:String,
    buttonText:String,
    mysteryNumber:Int,
    image: Painter,
    resetGame:()->Unit
){
    Dialog(onDismissRequest = resetGame){
        Column(
            modifier= Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(lavender),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text=text,
                fontWeight= FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text="The Mystery Number is $mysteryNumber",
                fontWeight= FontWeight.Bold,
                fontSize = 23.sp,
                textAlign = TextAlign.Center,
                fontFamily= FontFamily.Cursive
            )
            Image(
                modifier = Modifier.size(80.dp),
                painter= image,
                contentDescription = "Icon"
            )
            Button(
                onClick = resetGame,
                colors=ButtonDefaults.buttonColors(
                    containerColor = Maroon,
                    contentColor = Color.White
                )
            ) {
                Text(text = buttonText, fontSize = 18.sp)

            }

        }


    }
}
@Preview
@Composable
fun WinDialogPrev() {
    WinOrLoseDialog(
        text = "Congratulations\nYou won",
        buttonText = "Play Again",
        mysteryNumber = 32,
        image = painterResource(R.drawable.ic_win),
        resetGame = {}
    )
}

@Preview
@Composable
fun LoseDialogPrev() {
    WinOrLoseDialog(
        text = "Better Luck next time",
        buttonText = "Try Again",
        mysteryNumber = 32,
        image = painterResource(R.drawable.ic_lose),
        resetGame = {}
    )
}
