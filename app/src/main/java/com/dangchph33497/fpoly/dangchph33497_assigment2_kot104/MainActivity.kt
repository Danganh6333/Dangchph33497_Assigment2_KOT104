package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.AppNavHost
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.CategoryRepositry
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.ui.theme.Dangchph33497_Assigment2_KOT104Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dangchph33497_Assigment2_KOT104Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(navController = rememberNavController())
                }
            }
        }
    }
}

private val gelasioFamily = FontFamily(
    Font(R.font.gelasio_variablefont_wght, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.gelasio_italic_variablefont_wght, FontWeight.Normal, FontStyle.Normal)
)

private val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_10pt_regular, FontWeight.Normal, FontStyle.Normal),
    Font(
        R.font.nunitosans_italic_variablefont_ytlc_opsz_wdth_wght,
        FontWeight.Normal,
        FontStyle.Normal
    )
)

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.backgroundimage),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(
            modifier = Modifier
                .padding(27.dp, 0.dp, 0.dp, 60.dp)
                .fillMaxWidth()
                .fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.padding(top = 99.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "MAKE YOUR",
                    fontFamily = gelasioFamily,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF606060)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "HOME BEAUTIFUL",
                    fontFamily = gelasioFamily,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF303030)
                )
                Spacer(
                    modifier = Modifier
                        .height(28.dp)
                        .padding(bottom = 50.dp)
                ) // Adjust the space between texts
                Text(
                    text = "The best simple place where you\ndiscover most wonderful furnitures\nand make your home beautiful",

                    fontFamily = nunitoSansFamily,
                    softWrap = true,
                    lineHeight = 48.sp,
                    fontSize = 20.sp,
                    color = Color(0xFF808080),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp, 0.dp, 0.dp, 0.dp)
                )
            }
            ButtonWithColor(navController)
        }
    }
}

@Composable
fun ButtonWithColor(navController: NavHostController, modifier: Modifier = Modifier) {
    val Red = Color(0xFF242424)
    Button(
        onClick = {
            navController.navigate("${Screens.SignIn.route}")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Red
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 30.dp),
        modifier = modifier
            .padding(horizontal = 100.dp)
            .height(55.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 9.dp)
    ) {
        Text(
            text = "Get Started",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontFamily = gelasioFamily,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight(600)
        )
    }
}
