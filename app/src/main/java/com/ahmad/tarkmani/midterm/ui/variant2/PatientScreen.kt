package com.ahmad.tarkmani.midterm.ui.variant2


import androidx.compose.runtime.Composable
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.ahmad.tarkmani.midterm.ui.Patient

@Composable
fun PatientScreen(navController: NavController, context: Context) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val vaccinated = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Pizza Image")
        Column {
            TextField(
                label = {

                    Text(
                        text = "First Name  ",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                value = firstName.value,
                onValueChange = { value -> firstName.value = value },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )


            TextField(
                label = {
                    Text(
                        text = "Last Name ",
                        style = TextStyle(
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                value = lastName.value,
                onValueChange = { value -> lastName.value = value },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Vaccinated" , style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                ))
                Spacer(modifier = Modifier.padding(16.dp))
                Switch(checked = vaccinated.value, onCheckedChange = { vaccinated.value = it})
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = {
                if (firstName.value.isEmpty() || lastName.value.isEmpty()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                MainActivity.patients.add(
                    Patient(
                        firstName.value,
                        lastName.value,
                        vaccinated.value
                    )
                )
                firstName.value = ""
                lastName.value = ""
                Toast.makeText(context, "Patient added", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Write")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = {
                navController.navigate("list")
            }) {
                Text(text = "Read")
            }
        }
    }
}