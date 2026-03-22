package com.example.midterm

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.midterm.ui.theme.MidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidtermTheme {
                    EveryQuestion()
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
        Text("Clicked $count times")
        Button(
            onClick = { count += 1 }
        ) {
            Text("Clicked to increment")
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
// FIXING THE FOLLOWING:
/*
@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    Column {
        Text("Count: $count")
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}
 */
class CounterViewModel : ViewModel() {
    var count by mutableStateOf(0)
    // ViewModel function
    fun countHandler(){
        count += 1
    }
}

@Composable
fun CounterScreen(count: Int, increment: () -> Unit) {
    Column {
        Text("Count: $count")
        Button(
            onClick = { increment() }
        ) {
            Text("Increment")
        }
    }
}

// State hoisting view model to parent composable then passing params & functions to CounterScreen
@Composable
fun CounterScreenParent(viewModel: CounterViewModel = viewModel()) {
    CounterScreen(
        count = viewModel.count,
        increment = { viewModel.countHandler() }
    )
}

/* Q3 LazyLists */
@Composable
fun LazyListScreen(){
    // Includes a LazyList column, items() DSL, and a Card for each student name

    val students = listOf(
        "Alice","Bob","Charlie","Dana","Eric",
        "Fatima","Grace","Hiro","Isabel","Jack",
        "Karen","Luis","Maya","Nate","Olivia",
        "Priya","Quinn","Ravi","Sara","Tom"
    )
    // By default LazyColumn is scrollable, but for easy demonstration, here's a parent box that is smaller than the list
    Box(modifier=Modifier.fillMaxSize(0.35f).border(1.dp,color=Color.Black)){
        LazyColumn() {
            items(items=students){ student ->
                Card() {
                    Text(student)
                }
            }
        }
    }
}

@Composable
@Preview
fun LazyListScreenPreview(){
    LazyListScreen()
}

/* Combing Q1, Q2, Q3 into one Screen*/
@Composable
fun EveryQuestion(){
    Column(){
        Text("Q1: Simple counter with two buttons and number displayed starting at 0. Button change number.", modifier = Modifier.padding(10.dp))
        ButtonScreen()
        Text("Q2: Updated Counter Screen to use ViewModel with counter state and function inside the ViewModel. The composable calls these.", modifier = Modifier.padding(10.dp))
        CounterScreenParent()
        Text("Q3: LazyColumn of list of names which is scrollable and uses items() DSL", modifier = Modifier.padding(10.dp))
        LazyListScreen()
    }
}
