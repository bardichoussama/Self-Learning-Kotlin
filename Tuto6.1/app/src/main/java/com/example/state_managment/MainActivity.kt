package com.example.state_managment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.state_managment.ui.theme.State_ManagmentTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            State_ManagmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Counter()
                        Spacer(modifier = Modifier.height(16.dp))
                        AsyncDataLoader()
                        Spacer(modifier = Modifier.height(16.dp))
                        UserProfile(userId = "12345")
                        Spacer(modifier = Modifier.height(16.dp))
                        DataStream()
                    }
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text("Count: $count", style = MaterialTheme.typography.headlineSmall)
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun AsyncDataLoader(modifier: Modifier = Modifier) {
    var data by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        data = fetchData()
    }

    Text(
        text = data,
        style = MaterialTheme.typography.headlineSmall
    )
}

suspend fun fetchData(): String {
    delay(2000)
    val currentTime = LocalTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return "Current time: ${currentTime.format(formatter)}"
}

@Composable
fun UserProfile(userId: String) {
    var userDetails by remember { mutableStateOf("Loading...") }

    LaunchedEffect(userId) {
        userDetails = fetchUserDetails(userId)
    }

    Text(text = userDetails, style = MaterialTheme.typography.headlineSmall)
}

suspend fun fetchUserDetails(userId: String): String {
    delay(2000)
    return "Details for user: $userId"
}

@Composable
fun DataStream() {
    val dataFlow = remember {
        flow {
            for (i in 1..5) {
                emit("Item $i")
                delay(3000)
            }
        }
    }

    val data by dataFlow.collectAsState(initial = "Starting...")

    Text(text = data, style = MaterialTheme.typography.headlineSmall)
}

@Preview(showBackground = true)
@Composable
fun PreviewComponents() {
    State_ManagmentTheme {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Counter()
            Spacer(modifier = Modifier.height(16.dp))
            AsyncDataLoader()
            Spacer(modifier = Modifier.height(16.dp))
            UserProfile(userId = "12345")
            Spacer(modifier = Modifier.height(16.dp))
            DataStream()
        }
    }
}
