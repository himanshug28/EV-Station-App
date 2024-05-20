package com.razormist.evstation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun LoginScreen(navController:NavController) {
    var email by remember{
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isLoginSuccess = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


        Image(painter = painterResource(id = R.drawable.ev),contentDescription = "Login Image",modifier = Modifier.size(200.dp))
        Text(text = "Welcome", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Login to your account")
        OutlinedTextField(value = email, onValueChange = {
            email=it
        }, label = {
            Text(text = "Email Address")
        })
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = password, onValueChange = {
                           password=it
        }, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = {
            Log.i("Credential", "Email:$email, Password:$password")
            if (email == "email" && password == "password") {

                isLoginSuccess.value = true
                navController.navigate("HomeScreen")
            } else {
                isLoginSuccess.value = false
                Log.i("Login", "Login failed")
            }
        })
        {

            Text(text = "Login")


            /* Spacer(modifier = Modifier.height(32.dp))
            TextButton(onClick = { *//*TODO*//* }) {
                Text(text = "Forget Password")*/
        }
            //Register
            Spacer(modifier = Modifier.height(4.dp))
            TextButton(onClick = { navController.navigate(Routes.RegisterScreen) }) {
                Text(text = "Register New User")


            }}}
