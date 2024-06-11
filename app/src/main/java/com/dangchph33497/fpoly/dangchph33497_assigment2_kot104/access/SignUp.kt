package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.access

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.entities.AccountEntity
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.AccountViewModel

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: AccountViewModel) {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .background(color = Color("#FFFFFF".toColorInt()))
                .fillMaxSize()
                .padding(
                    top = 24.dp,
                    start = 24.dp,
                    bottom = 24.dp,
                    end = 24.dp
                )
        ) {
            TopLayout()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Create Account",
                color = Color("#909090".toColorInt()),
                fontWeight = FontWeight(700),
                fontFamily = merriweatherFamily,
                fontSize = 27.sp
            )
            SignUpBlock(navController, viewModel)
        }
    }
}

@Composable
fun SignUpBlock(navController: NavHostController, viewModel: AccountViewModel) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var fullName by rememberSaveable { mutableStateOf("") }
    val isEmailTaken = rememberSaveable { mutableStateOf(false) }
    val errorMessage = rememberSaveable { mutableStateOf("") }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 33.dp)
            .border(0.dp, Color.Gray, RoundedCornerShape(10.dp)),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(Color.White),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 19.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            CustomTextField(label = "Full Name", value = fullName, onValueChange = { fullName = it })
            CustomTextField(label = "Email", value = email, onValueChange = { email = it })
            CustomTextField(label = "Password", value = password, onValueChange = { password = it }, isPassword = true)
            Spacer(modifier = Modifier.height(16.dp))
            SignUpButtonWithColor(navController, email, password, fullName, viewModel, isEmailTaken, errorMessage)
            if (isEmailTaken.value) {
                Text(
                    text = "Email is already taken.",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            if (errorMessage.value.isNotEmpty()) {
                Text(
                    text = errorMessage.value,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Already have an account? Sign In",
                    color = Color("#303030".toColorInt()),
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clickable {
                            navController.navigate("${Screens.SignIn.route}")
                        },
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}


@Composable
fun SignUpButtonWithColor(
    navController: NavHostController,
    email: String,
    password: String,
    fullName: String,
    viewModel: AccountViewModel,
    isEmailTaken: MutableState<Boolean>,
    errorMessage: MutableState<String>
) {
    Button(
        onClick = {
            viewModel.isEmailTaken(email) { taken ->
                if (taken) {
                    isEmailTaken.value = true
                } else {
                    isEmailTaken.value = false
                    if (email.isNotBlank() && password.isNotBlank() && fullName.isNotBlank()) {
                        viewModel.addAccount(AccountEntity(email, password, fullName)) { success ->
                            if (success) {
                                navController.navigate("${Screens.SignIn.route}")
                            } else {
                                errorMessage.value = "Sign Up failed. Please try again."
                            }
                        }
                    } else {
                        errorMessage.value = "Please fill out all fields."
                    }
                }
            }
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color("#242424".toColorInt())
        ), shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp, vertical = 10.dp)
            .height(50.dp)
    ) {
        Text(
            text = "Sign Up",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight(600)
        )
    }
}


@Composable
fun CustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 2.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth,
                    )
                }
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                cursorBrush = SolidColor(Color.Black),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
            )
        }
    }
}
