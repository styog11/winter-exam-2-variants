package com.ahmad.tarkmani.midterm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmad.tarkmani.midterm.ui.theme.MyApplicationTheme
import com.ahmad.tarkmani.midterm.ui.variant1.HomeScreen
import com.ahmad.tarkmani.midterm.ui.variant1.OrderScreen
import com.ahmad.tarkmani.midterm.ui.variant1.ResultScreen

class MainActivity : ComponentActivity() {
    companion object {
        var client = ""
        var phone = ""
        var orderPrice = 0.0
        var deliveryFee = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController, this@MainActivity)
                        }
                        composable("order") {
                            OrderScreen(navController)
                        }
                        composable("result") {
                            ResultScreen(navController)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                navController.navigate("home")
            },
        ) {
            Text(text = "Variant 1")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Variant 2")
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}