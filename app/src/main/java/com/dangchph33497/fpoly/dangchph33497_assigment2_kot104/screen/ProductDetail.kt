package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.ui.theme.Dangchph33497_Assigment2_KOT104Theme
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.ProductViewModel

@Composable
fun ProductDetailScreen(navController: NavHostController,
                        productViewModel: ProductViewModel,
                        maSP :String?,
                        tenSP:String,
                        donGia:Float,
                        anh : Int,
                        maTheLoai:Int) {
    var quantity by remember { mutableStateOf(1) }
    val productName = remember {
        mutableStateOf(tenSP)
    }
    val productPrice = remember {
        mutableStateOf(donGia)
    }
    val productDetails: String =
        "Minimal Stand is made of natural wood. The design is very simple and minimal. This is truly one of the best pieces of furniture in any family for now. With 3 different colors, you can easily select the best match for your home."
    val productImageResId = remember {
        mutableStateOf(anh)
    }
    val customerRating: Int = 4

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = anh),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { navController.navigate(Screens.Bottom.route) },
                modifier = Modifier
                    .padding(16.dp)
                    .size(27.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = tenSP,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color("#303030".toColorInt())
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$ ${donGia * quantity}",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { if (quantity > 1) quantity-- },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_remove_24),
                        contentDescription = "Decrease Quantity",
                        tint = Color.Black
                    )
                }

                Text(
                    text = "$quantity",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "Increase Quantity",
                        tint = Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            (1..5).forEach { index ->
                Icon(
                    painter = painterResource(
                        id = if (index <= customerRating) R.drawable.baseline_star_24 else R.drawable.baseline_star_border_24
                    ),
                    contentDescription = "Star $index",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Yellow
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = productDetails,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(0.4f)
                    .height(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                    contentDescription = "Save",
                    modifier = Modifier.size(29.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color("#242424".toColorInt())
                ), shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .weight(1.6f)
                    .height(50.dp)
            ) {
                Text(text = "Add to cart")
            }
        }
    }
}


