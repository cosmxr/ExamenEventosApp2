package com.example.exameneventosapp2

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*


@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    var selectedLanguage by remember { mutableStateOf(sharedPreferences.getString("language", "en") ?: "en") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.select_language), style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            RadioButton(
                selected = selectedLanguage == "en",
                onClick = {
                    selectedLanguage = "en"
                    setLocale(context, "en")
                    saveLanguagePreference(sharedPreferences, "en")
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.english))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            RadioButton(
                selected = selectedLanguage == "es",
                onClick = {
                    selectedLanguage = "es"
                    setLocale(context, "es")
                    saveLanguagePreference(sharedPreferences, "es")
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.spanish))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("main") }) {
            Text(text = stringResource(R.string.save))
        }
    }
}

fun saveLanguagePreference(sharedPreferences: SharedPreferences, language: String) {
    with(sharedPreferences.edit()) {
        putString("language", language)
        apply()
    }
}

fun setLocale(context: Context, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = Configuration()
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}