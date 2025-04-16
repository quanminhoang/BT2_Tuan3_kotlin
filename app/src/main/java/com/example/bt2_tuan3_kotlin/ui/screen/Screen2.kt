package com.example.bt2_tuan3_kotlin.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bt2_tuan3_kotlin.R
import com.example.bt2_tuan3_kotlin.ui.components.OnBoarddingTexts
import com.example.bt2_tuan3_kotlin.ui.components.TopBar

@Composable
fun Screen2(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            TopBar(R.drawable.icon_dotscreen2)
            Column(
                modifier = Modifier
                    .weight(1.1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.frame),
                    contentDescription = "logo",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.9f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OnBoarddingTexts(
                    "Increase Work Effectiveness",
                    "Time management and the determination of more important tasks will give your job statistics better and always improve"
                )
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
}