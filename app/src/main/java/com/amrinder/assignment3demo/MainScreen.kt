package com.amrinder.assignment3demo

//class MainScreen {
//}

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animation Demo") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Navigation buttons with different colors
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimatedNavigationButton(
                    text = "Animation 1 Demo",
                    onClick = { navController.navigate("screen1") },
                    buttonColor = Color(0xFF9C27B0)
                )

                AnimatedNavigationButton(
                    text = "Animation 2 Demo",
                    onClick = { navController.navigate("screen2") },
                    buttonColor = Color(0xFF9C27B0)
                )

                AnimatedNavigationButton(
                    text = "Animation 3 Demo",
                    onClick = { navController.navigate("screen3") },
                    buttonColor = Color(0xFF9C27B0)
                )

                AnimatedNavigationButton(
                    text = "Animation 4 Demo",
                    onClick = { navController.navigate("screen4") },
                    buttonColor = Color(0xFF9C27B0)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // About Section
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                "About",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                "Student Name: $studentName",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            Text(
                "Student ID: $studentID",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 1.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun AnimatedNavigationButton(
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.primary
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        label = "buttonScale"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed)
            buttonColor.copy(alpha = 0.7f)  // Darkened version when pressed
        else
            buttonColor,
        label = "buttonColor"
    )

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .scale(scale)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    }
}