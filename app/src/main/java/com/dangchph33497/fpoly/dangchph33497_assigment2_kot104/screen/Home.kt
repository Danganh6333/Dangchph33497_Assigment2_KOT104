package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.R
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.extensions.toCategory
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.extensions.toProduct
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.model.Product
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.model.Type
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.CategoryViewModel
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.ProductViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    productViewModel: ProductViewModel,
    categoryViewModel: CategoryViewModel
) {
    val scrollState = rememberScrollState()
    val productList by productViewModel.productList.collectAsState(initial = emptyList())
    val categoryList by categoryViewModel.categoryList.collectAsState(initial = emptyList())
    var selectedCategoryId by remember { mutableStateOf<Int?>(null) }

    val filteredProducts = if (selectedCategoryId == null || selectedCategoryId == 0) {
        productList
    } else {
        productList.filter { it.cateID == selectedCategoryId }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(16.dp)
        ) {
            categoryList.forEach { type ->
                TypeItem(type = type.toCategory(),
                    onClick = { selectedCategoryId = type.cateID },
                    isSelected = selectedCategoryId == type.cateID
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp)
        ) {
            items(filteredProducts) { product ->
                ProductItem(product = product.toProduct(), navController)
            }
        }
    }
}

private val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_10pt_regular, FontWeight.Normal, FontStyle.Normal),
    Font(
        R.font.nunitosans_italic_variablefont_ytlc_opsz_wdth_wght,
        FontWeight.Normal,
        FontStyle.Normal
    )
)

@Composable
fun TypeItem(type: Type, onClick: () -> Unit, isSelected: Boolean) {
    val backgroundColor = if (isSelected) {
        Color.Gray
    } else {
        Color.Transparent
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 19.dp)
            .clickable { onClick() }

    ) {
        Box(
            modifier = Modifier
                .padding(2.dp)
                .size(50.dp)
                .background(color = backgroundColor),
            contentAlignment = Alignment.Center,
        ) {
            Image(painter = painterResource(id = type.CateIcon), contentDescription = "Logo")
        }
        Text(text = type.CateName, textAlign = TextAlign.Center)
    }
}

@Composable
fun ProductItem(product: Product, navController: NavController) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                navController.navigate(
                    "${Screens.Detail.route
                    }/${Uri.encode(product.maSP.toString())
                    }/${Uri.encode(product.tenSP)
                    }/${product.donGia
                    }/${product.anh
                    }/${product.maTheLoai
                    }"
                )
            }
            .padding(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = product.anh),
                contentDescription = product.tenSP,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20)
                    )
                    .padding(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                    contentDescription = "Add to Cart",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(18.dp)
                )
            }
        }
        Text(
            text = product.tenSP,
            color = Color("#606060".toColorInt()),
            modifier = Modifier.padding(top = 8.dp),
            fontFamily = nunitoSansFamily,
        )
        Text(
            text = "$${product.donGia}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
