package com.example.affirmationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmationcard.ui.theme.AffirmationCardTheme

// List of affirmations
val affirmations = listOf(
    "Crois en toi-même et en toutes tes capacités.",
    "Chaque jour est une nouvelle opportunité.",
    "Tu es plus fort que tu ne le penses.",
    "N'abandonne jamais, les miracles prennent du temps.",
    "Le succès commence par la volonté de l'atteindre."
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationApp()
        }
    }
}

// Affirmation List Composable
@Composable
fun AffirmationList(affirmations: List<String>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(affirmations) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}

// Affirmation Card Composable
@Composable
fun AffirmationCard(affirmation: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = affirmation,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

// Main App Composable
@Composable
fun AffirmationApp() {
    AffirmationCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AffirmationList(affirmations)
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun AffirmationAppPreview() {
    AffirmationApp()
}
