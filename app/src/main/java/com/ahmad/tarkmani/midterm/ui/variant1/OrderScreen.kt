package com.ahmad.tarkmani.midterm.ui.variant1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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


@Composable
fun OrderScreen(navController: NavController) {
    val meat = remember { mutableStateOf(false) }
    val cheese = remember { mutableStateOf(false) }
    val veggies = remember { mutableStateOf(false) }
    val deliver = remember { mutableStateOf(false) }
    val size = remember { mutableIntStateOf(0) }
    val sizePrices = listOf(9.0, 10.0, 11.0)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "ORDER",
            style = TextStyle(
                color = Color.Green,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row {
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
                text = "${MainActivity.client}  ${MainActivity.phone}",
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Image(painter = painterResource(id = R.drawable.pizza), contentDescription = "Pizza Image")
        Spacer(modifier = Modifier.padding(8.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = size.value == 0, onClick = {
                        size.value = 0
                    })
                    Text(text = "Small - 9$")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = size.value == 1, onClick = {
                        size.value = 1
                    })
                    Text(text = "Medium - 10$")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = size.value == 2, onClick = {
                        size.value = 2
                    })
                    Text(text = "Large - 10$")
                }
            }
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = meat.value, onCheckedChange = { v ->
                        meat.value = v
                    })
                    Text(text = "Meat - 2$")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = cheese.value, onCheckedChange = { v ->
                        cheese.value = v
                    })
                    Text(text = "Cheese - 2$")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = veggies.value, onCheckedChange = { v ->
                        veggies.value = v
                    })
                    Text(text = "Veggies - 2$")
                }
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Deliver required ?")
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "Yes")
            Switch(checked = deliver.value, onCheckedChange = {
                deliver.value = it
            })
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                navController.navigate("home")
            }) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {
                navController.navigate("order")
                if(deliver.value){
                    MainActivity.deliveryFee = 5.5
                }
                var price = sizePrices[size.value]
                if(meat.value){
                    price += 2
                }
                if(cheese.value){
                    price += 2
                }
                if(veggies.value){
                    price += 2
                }
                MainActivity.orderPrice = price
                navController.navigate("result")
            }) {
                Text(text = "NEXT")
            }
        }
    }
}
