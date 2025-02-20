

package com.example.android_strepapp
import Desclaimer
import FamilyMembers
import FinalTestResults
import ForgotPassword1
import HowToUse1
import HowToUse2
import HowToUse3
import HowToUse4
import HowToUse5
import Menu
import Login
import Profile
import Profile2
import Register
import RegisterScreen
import ResetPassword
import SelectLanguage
import SplashScreen
import StartTest1
import StartTest2
import Symptoms
import Symptoms2
import Symptoms3
import TermsAndConditions
import Verification
import ImageCapture
import ImageCaptureStatus
import ProcessingTestResults
import ReviewSymptoms
import SymptomsViewModel
import TestHistory2
import Testing
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navController: NavHostController) {
    val symptomsViewModel: SymptomsViewModel = viewModel()
    NavHost(navController = navController, startDestination = "splash") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen()
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("symptoms") {
            SymptomsScreen(navController = navController)
        }
        composable("imageCapture") {
//            ImageCaptureScreen()
        }
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("selectLanguage") {
            SelectLanguage(navController = navController)
        }
        composable("login1") {
            Login(navController = navController)
        }
        composable("register1") {
            Register(navController = navController)
        }
        composable("forgotPassword") {
            ForgotPassword1(navController = navController)
        }
        composable("resetPassword") {
            ResetPassword(navController = navController)
        }
        composable("verify") {
            Verification(navController = navController)
        }
        composable("terms") {
            TermsAndConditions(navController = navController)
        }
        composable("desclaimer") {
            Desclaimer(navController = navController)
        }
        composable("profile1") {
            Profile(navController = navController)
        }
//        composable("profile2") {
//            Profile2(navController = navController)
//        }
        composable(
            "profile2/{name}/{details}/{imageRes}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType; defaultValue = "Default Name" },
                navArgument("details") { type = NavType.StringType; defaultValue = "Default Details" },
                navArgument("imageRes") { type = NavType.IntType; defaultValue = R.drawable.doctor2 }
            )
        ) { backStackEntry ->
            // Extracting the arguments safely
            val name = backStackEntry.arguments?.getString("name") ?: "Default Name"
            val details = backStackEntry.arguments?.getString("details") ?: "Default Details"
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: R.drawable.doctor2

            // Pass these values to your Profile2 Composable
            Profile2(
                navController = navController,
                name = name,
                details = details,
                imageRes = imageRes
            )
        }

        composable("familymembers") {
            FamilyMembers(navController = navController)
        }
        composable("symptoms1") {
            Symptoms(navController = navController,viewModel = symptomsViewModel  )
        }
        composable("symptoms2") {
            Symptoms2(navController = navController,viewModel = symptomsViewModel  )
        }
        composable("symptoms3") {
            Symptoms3(navController = navController,viewModel = symptomsViewModel  )
        }
        composable("starttest2") {
            StartTest2(navController = navController)
        }
        composable("starttest1") {
            StartTest1(navController = navController,viewModel = symptomsViewModel )
        }
        composable("imagecapture") {
            ImageCapture(navController = navController)
        }
        composable("imagecapturestatus/{imageUri}") { backStackEntry ->
            val imageUri = backStackEntry.arguments?.getString("imageUri") ?: ""
            ImageCaptureStatus(navController = navController, imageUri = imageUri)
        }
        composable("imagecapture2") {
            ImageCapture2(navController = navController)
        }
        composable("reviewsymptoms/{imageUri}") { backStackEntry ->
            val imageUri = backStackEntry.arguments?.getString("imageUri")
            ReviewSymptoms(navController, imageUri ?: "",  viewModel = symptomsViewModel)
        }
        composable(
            "testHistory/{name}/{details}/{imageRes}",
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val details = backStackEntry.arguments?.getString("details") ?: ""
            val imageRes = backStackEntry.arguments?.getString("imageRes")?.toInt() ?: R.drawable.sample1

            TestHistory(
                name = name,
                details = details,
                imageRes = imageRes,
                navController = navController
            )
        }
        composable("menu") {
            Menu(navController = navController)
        }
        composable("settings") {
            Settings(navController = navController)
        }
        composable("customerSupport") {
            CustomerSupport(navController = navController)
        }
        composable("supportHistory") {
            SupportHistory(navController = navController)
        }
        composable("consultPhysician") {
            ConsultPhysician(navController = navController)
        }
        composable("addReview") {
            AddReview(navController = navController)
        }
        composable("showReview") {
            ShowReview(navController = navController)
        }
        composable("subscription") {
            Subscription(navController = navController)
        }
        composable("buySubscription/{price}/{description}") { backStackEntry ->
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            BuySubscription(navController = navController, price = price, description = description) // Pass navController
        }
        composable("about") {
            AboutStrepApp(navController = navController)
        }
        composable("processingTestResults") {
            ProcessingTestResults(navController = navController)
        }
        composable(
            "testHistory2/{testData}",
            arguments = listOf(navArgument("testData") { type = NavType.StringType })
        ) { backStackEntry ->
            val testData = backStackEntry.arguments?.getString("testData")
            val context = LocalContext.current  // Get the context here
            TestHistory2(testData = testData, navController = navController, context = context)
        }
        composable("finalTestResults") {
            FinalTestResults(navController = navController)
        }
        composable("howToUse1") {
            HowToUse1(navController = navController)
        }
        composable("howToUse2") {
            HowToUse2(navController = navController)
        }
        composable("howToUse3") {
            HowToUse3(navController = navController)
        }
        composable("howToUse4") {
            HowToUse4(navController = navController)
        }
        composable("howToUse5") {
            HowToUse5(navController = navController)
        }
        composable("testing") {
            Testing()
        }
    }
}





