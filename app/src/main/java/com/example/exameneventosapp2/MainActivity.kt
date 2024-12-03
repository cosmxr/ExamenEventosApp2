package com.example.exameneventosapp2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.exameneventosapp2.SettingsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Exameneventosapp2Theme {
                val navController = rememberNavController()
                val events = remember { mutableStateListOf<Event>() }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("") },
                            navigationIcon = {
                                if (currentRoute != "main") {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        IconButton(onClick = { navController.navigateUp() }) {
                                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                                        }
                                        Spacer(modifier = Modifier.weight(1f))
                                        IconButton(onClick = { navController.navigate("settings") }) {
                                            Icon(Icons.Default.Settings, contentDescription = stringResource(R.string.settings))
                                        }
                                    }
                                }
                            },
                            actions = {
                                if (currentRoute == "main") {
                                    IconButton(onClick = { navController.navigate("addEvent") }) {
                                        Icon(Icons.Default.Add, contentDescription = stringResource(R.string.add_event))
                                    }
                                    IconButton(onClick = { navController.navigate("settings") }) {
                                        Icon(Icons.Default.Settings, contentDescription = stringResource(R.string.settings))
                                }
                            }}
                        )
                    }
                ) {
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") { MainScreen(navController, events) }
                        composable("addEvent") { AddEventScreen(navController, events) }
                        composable("settings") { SettingsScreen(navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController, events: List<Event>) {
    Column {
        if (events.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.empty_event))
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 186.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                items(events) { event ->
                    EventItem(event)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

    }
}

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = event.name, style = MaterialTheme.typography.titleLarge)
                Text(text = event.description, style = MaterialTheme.typography.bodyMedium)
                Text(text = "${event.price} €", style = MaterialTheme.typography.bodyMedium)
                Text(text = event.address, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}