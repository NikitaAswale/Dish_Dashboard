package com.example.dishdashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DishDashboard() {

    val viewModel: DishDashboard_ViewModel = viewModel()
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isFormValid = text.isNotBlank() && password.isNotBlank()
    val user_date  by viewModel.userdata.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize().
        background(Brush.verticalGradient(colors = listOf(Color(0xFF1D2B64), Color(0xFF4DA0B0))))
        //contentAlignment = Alignment.Center,

    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier.size(100.dp).clip(shape = CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "DishDashboard",
                modifier = Modifier,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = Color.White
            )

            Text(
                "Restaurant Management Made Easy",
                modifier = Modifier,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                color = Color.White
            )

        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(26.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "Welcome Back",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Blue
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = {
                        Text(
                            "Username",
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                    }
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            "Password",
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                    }
                )

                Spacer(modifier = Modifier.height(6.dp))

                Button(onClick = {
                    viewModel.addUserData(text, password)
                    text = ""
                    password = ""
                }, modifier = Modifier.fillMaxWidth(),
                    enabled = isFormValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFormValid) Color(0xFF80AFFF) else Color.LightGray
                    )
                 ) {

                    Text("Sign In ->")

                }

                Spacer(modifier = Modifier.height(10.dp))

                Text("Forgot Password?")
            }
        }
        }
    }
}