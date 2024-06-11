package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens


@Composable
fun CongratsButtonWithColor(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#242424".toColorInt())
        ),
        shape = RoundedCornerShape(7.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .height(50.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight(450)
        )
    }
}

@Composable
fun CongratsButtonWithBorder(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(7.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .height(90.dp)
            .border(2.dp, shape = RoundedCornerShape(7.dp), color = Color("#242424".toColorInt()))
    ) {
        Text(
            text = text,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight(400)
        )
    }
}

val merriweatherFamily = FontFamily(
    Font(R.font.merriweather_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.merriweather_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.merriweather_italic, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.merriweather_bolditalic, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.merriweather_light, FontWeight.Bold, FontStyle.Italic)
)

@Composable
fun CongratulationLayout(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 39.sp,
            fontFamily = merriweatherFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .size(290.dp)
                .padding(bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(40.dp)
                    .padding(bottom = 19.dp)
            )
        }
        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            fontSize = 21.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 30.dp)
        )
        CongratsButtonWithColor(
            text = "Track your orders",
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(vertical = 10.dp)
        )
        CongratsButtonWithBorder(
            text = "BACK TO HOME",
            onClick = { navController.navigate("${Screens.Bottom.route}") },
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(vertical = 10.dp)
        )
    }
}
