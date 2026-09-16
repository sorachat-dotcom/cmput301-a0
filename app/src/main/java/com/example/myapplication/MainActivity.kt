package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun randomChoose(chance: Float): Boolean {
    val chosen = Random.nextFloat()
    return (chosen < chance)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var setText by remember { mutableStateOf("Do we wanna go there?") }
    var backgroundColor by remember { mutableStateOf(Color.White) }
    Column (
        modifier = Modifier.fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = setText,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = modifier.fillMaxWidth()
        )

        //Buttons!
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            //YES button
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    if (randomChoose(0.5f)) {
                        setText = "Nice! Let's go then."
                        backgroundColor = Color.Green
                    }
                    else {
                        setText = "Nope, we ARE staying home."
                        backgroundColor = Color.Cyan
                    }
                }
            ) {
                Text("Yes!")
            }

            //Maybe button
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    if (randomChoose(0.25f)) {
                        setText = "Yeah we can head out."
                        backgroundColor = Color.Green
                    }
                    else {
                        setText = "No. Let's stay home."
                        backgroundColor = Color.Cyan
                    }
                }
            ) {
                Text("Maybe?")
            }

            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    if (randomChoose(0.1f)) {
                        setText = "You're heading out."
                        backgroundColor = Color.Green
                    }
                    else {
                        setText = "Stay home and enjoy your rest."
                        backgroundColor = Color.Cyan
                    }
                }
            ) {
                Text("Absolutely not")
            }
        }
        Text(
            text = "Student ID: 1851649\nCCID: sorachat",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}