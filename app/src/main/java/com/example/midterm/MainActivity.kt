package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.midterm.ui.theme.MidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidtermTheme {
                    ButtonScreen()
                }
            }
        }
}

/*Q1 Compose State & Recomposition*/
@Composable
fun ButtonScreen() {
    // rememberSaveable to survive screen rotation
    var count by rememberSaveable { mutableStateOf(0) }
    // Button to increment the count
    Column() {
        Button(
            onClick = { count += 1 }
        ) {
            Text("Clicked $count times")
        }
        // Button to reset the count
        Button(
            onClick = { count = 0 }
        ){
            Text("Reset count")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    MidtermTheme {
        ButtonScreen()
    }
}

/*Q2 ViewModel & Unidirectional DataFlow */