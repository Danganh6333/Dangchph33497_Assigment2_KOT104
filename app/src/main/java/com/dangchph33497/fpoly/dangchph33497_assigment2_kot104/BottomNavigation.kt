@file:OptIn(ExperimentalMaterial3Api::class)

package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation.Screens
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.AccountRepository
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.CategoryRepositry
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.ProductRepositry
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.BookmarkLayout
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.HomeScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.NotificationScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.ProfileScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.AccountViewModel
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.CategoryViewModel
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.ProductViewModel

@Composable
fun NavigationLayout(navHostController: NavHostController) {
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf("home") }
    val currentDestination by navigationController.currentBackStackEntryAsState()
    val isSearching = remember { mutableStateOf(false) }
    val searchQuery = remember { mutableStateOf("") }
    var title = currentDestination?.destination?.route ?: "Thanh Toan"
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    val accountViewModel = AccountViewModel(AccountRepository(db))
    val categoryViewModel = CategoryViewModel(CategoryRepositry(db))
    val productViewModel = ProductViewModel(ProductRepositry(db),categoryViewModel)
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column {
                            if (selected.value == "home") {
                                title = ""
                                Text(
                                    "Make Your",
                                    color = Color.Gray,
                                    fontSize = 10.sp,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                                Text("Beautiful", color = Color.Black, fontSize = 21.sp)
                            } else {
                                Text(title)
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(
                            imageVector = Icons.Sharp.Search,
                            contentDescription = "Search",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navHostController.navigate("${Screens.Cart.route}") }) {
                        if (selected.value == "profile") {
                            Icon(
                                imageVector = Icons.Rounded.ExitToApp,
                                contentDescription = "Cart",
                                tint = Color.Black
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = "Cart",
                                tint = Color.Black
                            )
                        }

                    }
                }
            )
        },
        bottomBar = {
            MyBottomAppBar(navigationController, selected)
        },
    ) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(
                    navController = navHostController,
                    productViewModel = productViewModel,
                    categoryViewModel =  categoryViewModel
                )
            }
            composable(Screens.Bookmark.route) { BookmarkLayout() }
            composable(Screens.Notification.route) { NotificationScreen() }
            composable(Screens.Profile.route) { ProfileScreen(navController = navHostController) }
        }
    }
}

@Composable
fun MyBottomAppBar(navigationController: NavHostController, selected: MutableState<String>) {
    BottomAppBar(containerColor = Color.White) {
        IconButton(
            onClick = {
                selected.value = "home"
                navigationController.navigate(Screens.Home.route) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "home") Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "favorite"
                navigationController.navigate(Screens.Bookmark.route) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "favorite") Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "notifications"
                navigationController.navigate(Screens.Notification.route) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "notifications") Icons.Filled.Notifications else Icons.Outlined.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
        IconButton(
            onClick = {
                selected.value = "profile"
                navigationController.navigate(Screens.Profile.route) {
                    popUpTo(0)
                }
            },
            modifier = Modifier.weight(1f)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = if (selected.value == "profile") Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(26.dp),
                    tint = Color.Black
                )
            }
        }
    }
}
