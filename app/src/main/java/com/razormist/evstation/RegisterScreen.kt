package com.razormist.evstation

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import kotlinx.coroutines.flow.first



data class User(
    val name: String,
    val email: String,
    val password: String
)

@Composable

fun RegisterScreen(navController: NavController)   {


    // Create a DataStore instance

    var name by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var confirmpassword by remember{
        mutableStateOf("")
    }
    val isNotMatching = remember {
        derivedStateOf {
            password != confirmpassword
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ev),contentDescription = "Register Image",modifier = Modifier.size(200.dp))
        Text(text = "Welcome", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Register to your account")
        OutlinedTextField(value = name, onValueChange = {
          name = it
        },
            label = {
                Text(text ="name")
            })

        OutlinedTextField(value = email, onValueChange = {
            email=it
        }, label = {
            Text(text = "Email Address")
        })

        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = password, onValueChange = {
            password=it
        }, label = {
            Text(text = "Enter Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = confirmpassword, onValueChange = {
            confirmpassword=it
        }, label = {
            Text(text = "Enter Confirm Password")
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = { Log.i("RegCredential","name:$name,Email:$email,Password:$password,confirmPassword:$confirmpassword") }) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(4.dp))
if (isNotMatching.value){
  Text(text = "password is not matching")
}
Spacer(modifier = Modifier.height(16.dp))

TextButton(onClick = { navController.navigate("LoginScreen") }) {
  Text(text = "Go Back to Login")
}

}}
