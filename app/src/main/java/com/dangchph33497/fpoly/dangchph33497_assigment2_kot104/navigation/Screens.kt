package com.dangchph33497.fpoly.dangchph33497_assigment2_kot104.navigation

enum class Screen {
    SPLASH,
    SIGN_IN,
    SIGN_UP,
    BOTTOM,
    CONGRATULATION,
    HOME,
    DETAIL,
    CART,
    BOOKMARK,
    NOTIFICATION,
    PROFILE,
    SETTING,
    REVIEW,
    PAYMENT,
    SHIPPING,
    ORDERS,

}

sealed class Screens(val route: String) {
    object Splash : Screens(Screen.SPLASH.name)
    object SignIn : Screens(Screen.SIGN_IN.name)
    object SignUp : Screens(Screen.SIGN_UP.name)
    object Bottom : Screens(Screen.BOTTOM.name)
    object Congratulation : Screens(Screen.CONGRATULATION.name)
    object Home : Screens(Screen.HOME.name)
    object Bookmark : Screens(Screen.BOOKMARK.name)
    object Notification : Screens(Screen.NOTIFICATION.name)
    object Profile : Screens(Screen.PROFILE.name)
    object Cart : Screens(Screen.CART.name)
    object Detail : Screens(Screen.DETAIL.name)
    object Setting : Screens(Screen.SETTING.name)
    object Review : Screens(Screen.REVIEW.name)
    object Payment : Screens(Screen.PAYMENT.name)
    object Shipping: Screens(Screen.SHIPPING.name)
    object Orders: Screens(Screen.ORDERS.name)
}