package com.ahmad.tarkmani.midterm.ui.variant2

import androidx.compose.runtime.Composable
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ahmad.tarkmani.midterm.MainActivity

@Composable
fun LoginScreen(navController: NavController, context: Context) {
    val name = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Login",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Column {
            TextField(
                prefix = {

                    Text(
                        text = "Enter name  ",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                value = name.value,
                onValueChange = { value -> name.value = value },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )


            TextField(
                prefix = {
                    Text(
                        text = "Password  ",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { value -> password.value = value },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = {
                if (name.value.isEmpty() || password.value.isEmpty()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                MainActivity.user = name.value
                navController.navigate("patient")
            }) {
                Text(text = "LOGIN")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text(text = "CANCEL")
            }
        }
    }
}