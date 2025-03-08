package com.ahmad.tarkmani.midterm.ui.variant1


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ahmad.tarkmani.midterm.MainActivity
import com.ahmad.tarkmani.midterm.R
import java.text.Format


@Composable
fun ResultScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "RESULT",
            style = TextStyle(
                color = Color.Red,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            Modifier
                .border(2.dp, Color.Green)
                .padding(8.dp)
        ) {
            Text(
                text = "Client:",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = MainActivity.client,
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            Modifier
                .border(2.dp, Color.Blue)
                .padding(6.dp)
        ) {
            Row(
                Modifier
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order Price :", style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = formattedPrice(MainActivity.orderPrice), style = TextStyle(
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            Row(
                Modifier
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Delivery fee :", style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = formattedPrice(MainActivity.deliveryFee), style = TextStyle(
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                Modifier
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Total :", style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = formattedPrice(MainActivity.orderPrice + MainActivity.deliveryFee), style = TextStyle(
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                MainActivity.clear()
                navController.navigate("main")
            }) {
                Text(text = "EXIT")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {
                navController.navigate("order")
            }) {
                Text(text = "BACK")
            }
        }
    }
}

fun formattedPrice(price: Double): String {
    return String.format("%.2f$", price)
}