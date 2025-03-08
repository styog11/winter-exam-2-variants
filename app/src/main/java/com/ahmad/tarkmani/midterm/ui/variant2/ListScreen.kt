package com.ahmad.tarkmani.midterm.ui.variant2

import androidx.compose.foundation.border
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ahmad.tarkmani.midterm.MainActivity

@Composable
fun ListScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text(
            text = "File Content",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row {
            Text(
                text = "User: ",
                style = TextStyle(
                    fontSize = 40.sp,
                )
            )
            Text(
                text = MainActivity.user,
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
            Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                Text(
                    text = "Name",
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Last Name",
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Vaccin_Status",
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
         Column (
             Modifier
                 .fillMaxWidth()
                 .padding(8.dp)
                 .border(2.dp, Color.Red)){
                        MainActivity.patients.map {
                            Row {
                                Text(
                                    text = it.firstName,
                                    maxLines = 1,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    ),
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = it.lastName,
                                    maxLines = 1,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    ),
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = if (it.vaccinStatus) "Y" else "N",
                                    maxLines = 1,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    ),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            MainActivity.clear()
            navController.navigate("main")
        }) {
            Text(text = "Exit App")
        }
    }
}