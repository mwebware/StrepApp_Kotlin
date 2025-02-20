//package com.example.android_strepapp
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import com.example.android_strepapp.ui.theme.Android_StrepappTheme
//import androidx.compose.ui.Modifier
//import androidx.compose.foundation.layout.fillMaxSize
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Android_StrepappTheme {
//                Surface(modifier = Modifier.fillMaxSize()) {
//                    Navigation() // Set up navigation
//                }
//            }
//        }
//    }
//}


//package com.example.android_strepapp
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Surface
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.android_strepapp.ui.theme.Android_StrepappTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Android_StrepappTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color.White // Set your background color
//                ) {
//                    val navController = rememberNavController()
//                    Navigation(navController)
//                }
//            }
//        }
//    }
//}

package com.example.android_strepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_strepapp.ui.theme.Android_StrepappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Allows the app to use edge-to-edge display
        setContent {
            Android_StrepappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Set your background color
                ) {
                    val navController = rememberNavController()
                    Navigation(navController) // Set up navigation
                }
            }
        }
    }
}

