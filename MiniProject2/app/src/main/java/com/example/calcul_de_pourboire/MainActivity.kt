package com.example.calcul_de_pourboire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calcul_de_pourboire.ui.theme.Calcul_de_pourboireTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calcul_de_pourboireTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    // Main layout for the app
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Amount input field
        var amountInput by remember { mutableStateOf("") }
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Montant de l'addition") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Tip percentage slider
        var tipPercentage by remember { mutableStateOf(15f) }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Pourcentage : ${tipPercentage.toInt()}%")
            Slider(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                valueRange = 0f..30f,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Calculations
        val amount = amountInput.toFloatOrNull() ?: 0f
        val tipAmount = amount * tipPercentage / 100
        val totalAmount = amount + tipAmount

        // Display calculated values
        Text("Pourboire : %.2f MAD".format(tipAmount))
        Text("Total : %.2f MAD".format(totalAmount))
    }
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorAppPreview() {
    Calcul_de_pourboireTheme {
        TipCalculatorApp()
    }
}
