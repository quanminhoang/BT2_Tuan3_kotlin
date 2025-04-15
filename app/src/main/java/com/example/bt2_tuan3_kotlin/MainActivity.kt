package com.example.bt2_tuan3_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bt2_tuan3_kotlin.R.drawable.ic_launcher_background
import com.example.bt2_tuan3_kotlin.ui.theme.BT2_tuan3_kotlinTheme
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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


    @Composable
    fun LoadingScreen(navController: NavController) {
        LaunchedEffect(Unit) {
            delay(1000)
            navController.navigate("screen1")
        }
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.uth),
                        contentDescription = "logo",
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .height(100.dp)
                            .fillMaxSize()
                            .padding(bottom = 10.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "UTH SmartTasks",
                        fontSize = 32.sp,
                        color = Color(0xFF2196F3),
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif,
                    )
                }
            }
        }
    }

    @Composable
    fun ScreenIndicator(currentIndex: Int, totalDots: Int = 3) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == currentIndex) Color(0xFF2196F3)
                            else Color(0xFFBDBDBD)
                        )
                )
            }
        }
    }


    @Composable
    fun TopBar(currentIndex: Int) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ScreenIndicator(currentIndex = currentIndex)
            Text(
                text = "Skip", color = Color.Gray, fontSize = 16.sp, fontWeight = FontWeight.Medium
            )
        }
    }

    @Composable
    fun Screen1(navController: NavController) {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(currentIndex = 0) }) { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)

            ) {
                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bro),
                        contentDescription = "logo",
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Easy Time Management",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
                            textAlign = TextAlign.Center

                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        ),
                        onClick = { navController.navigate("screen2") },
                    ) {
                        Text(
                            text = "Next", fontSize = 20.sp, modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Screen2(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Box(
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.frame),
                    contentDescription = "logo",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Increase Work Effectiveness",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Time management and the determination of more important tasks will give your job statistics better and always improve",
                        textAlign = TextAlign.Center

                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(modifier = Modifier
                    .weight(0.15f)
                    .height(56.dp),
                    onClick = { navController.popBackStack() }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.btn_back),
                        contentDescription = "back",
                        tint = Color.Unspecified
                    )
                }

                Spacer(modifier = Modifier.weight(0.05f))

                Button(modifier = Modifier.weight(0.8f), colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ), onClick = { navController.navigate("screen3") }) {
                    Text(
                        text = "Next",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun Screen3(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Box(
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image3),
                    contentDescription = "logo",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Reminder Notification",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
                        textAlign = TextAlign.Center

                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(modifier = Modifier
                    .weight(0.15f)
                    .height(56.dp),
                    onClick = { navController.popBackStack() }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.btn_back),
                        contentDescription = "back",
                        tint = Color.Unspecified
                    )
                }

                Spacer(modifier = Modifier.weight(0.05f))

                Button(modifier = Modifier.weight(0.8f), colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ), onClick = {}) {
                    Text(
                        text = "Get Started",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}