package com.example.bt2_tuan3_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bt2_tuan3_kotlin.ui.screen.LoadingScreen
import com.example.bt2_tuan3_kotlin.ui.screen.Screen1
import com.example.bt2_tuan3_kotlin.ui.screen.Screen2
import com.example.bt2_tuan3_kotlin.ui.screen.Screen3
import com.example.bt2_tuan3_kotlin.ui.theme.BT2_tuan3_kotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BT2_tuan3_kotlinTheme {
                val navController = rememberNavController()
                NavHost(navController, "loading") {
                    composable("loading") { LoadingScreen(navController) }
                    composable("screen1") { Screen1(navController) }
                    composable("screen2") { Screen2(navController) }
                    composable("screen3") { Screen3(navController) }
                }
            }
        }
    }
}







