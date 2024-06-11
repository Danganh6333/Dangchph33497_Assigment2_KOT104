package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.NavigationLayout
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.SplashScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.access.SignInScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.access.SignUpScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.AccountRepository
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.CategoryRepositry
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.repository.ProductRepositry
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.roomDatabase.AppDatabase
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.BookmarkLayout
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.CartLayout
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.CongratulationLayout
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.HomeScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.NotificationScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.OrderScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.PaymentMethodScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.ProductDetailScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.ProfileScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.ReviewScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.SettingScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.screen.ShippingScreen
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.AccountViewModel
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.CategoryViewModel
import com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.viewModel.ProductViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screens.Splash.route,
) {
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    val accountViewModel = AccountViewModel(AccountRepository(db))

    val categoryViewModel = CategoryViewModel(CategoryRepositry(db))
    val productViewModel = ProductViewModel(ProductRepositry(db), categoryViewModel = categoryViewModel)
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screens.SignIn.route) {
            SignInScreen(navController = navController,accountViewModel)
        }
        composable(Screens.SignUp.route) {
            SignUpScreen(navController = navController,accountViewModel)
        }
        composable(Screens.Bottom.route) {
            NavigationLayout(navController)
        }
        composable(Screens.Congratulation.route) {
            CongratulationLayout(navController = navController)
        }
        composable(Screens.Home.route) {
            HomeScreen(navController = navController,productViewModel = productViewModel, categoryViewModel = categoryViewModel)
        }
        composable(Screens.Bookmark.route) {
            BookmarkLayout()
        }
        composable(Screens.Notification.route) {
            NotificationScreen()
        }
        composable(Screens.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screens.Congratulation.route) {
            CongratulationLayout(navController = navController)
        }
        composable(
            route = "${Screens.Detail.route}/{maSP}/{tenSP}/{donGia}/{anh}/{maTheLoai}",
            arguments = listOf(
                navArgument("maSP") { type = NavType.StringType },
                navArgument("tenSP") { type = NavType.StringType },
                navArgument("donGia") { type = NavType.FloatType },
                navArgument("anh") { type = NavType.IntType },
                navArgument("maTheLoai") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val maSP = backStackEntry.arguments?.getString("maSP")
            val tenSP = backStackEntry.arguments?.getString("tenSP") ?: ""
            val donGia = backStackEntry.arguments?.getFloat("donGia") ?: 0f
            val anh = backStackEntry.arguments?.getInt("anh") ?: 0
            val maTheLoai = backStackEntry.arguments?.getInt("maTheLoai") ?: 0
            ProductDetailScreen(
                navController = navController,
                productViewModel = productViewModel,
                maSP = maSP,
                tenSP = tenSP,
                donGia = donGia,
                anh = anh,
                maTheLoai = maTheLoai
            )
        }

        composable(Screens.Bookmark.route) {
            BookmarkLayout()
        }
        composable(Screens.Cart.route) {
            CartLayout(navController = navController)
        }
        composable(Screens.Setting.route) {
            SettingScreen(navController = navController)
        }
        composable(Screens.Review.route) {
            ReviewScreen(navController = navController)
        }
        composable(Screens.Payment.route) {
            PaymentMethodScreen(navController = navController)
        }
        composable(Screens.Shipping.route) {
            ShippingScreen(navController = navController)
        }
        composable(Screens.Orders.route) {
            OrderScreen(navController = navController)
        }
    }
}