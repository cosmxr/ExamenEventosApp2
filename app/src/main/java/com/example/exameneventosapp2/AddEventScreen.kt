package com.example.exameneventosapp2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//pantalla para añadir un evento
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventScreen(navController: NavController, events: MutableList<Event>) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val invalidPriceMessage = stringResource(R.string.invalid_price)

    //textfields para completar los datos del evento
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.event_name)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(R.string.event_description)) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text(stringResource(R.string.event_price)) },
            //control de errores de input incorrecto
            isError = errorMessage.isNotEmpty()
        )
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(stringResource(R.string.event_address)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            //botones para guardar o cerrar la pantalla
            Button(onClick = {
                val priceValue = price.toDoubleOrNull()
                if (priceValue == null) {
                    //se emite el mensaje de error
                    errorMessage = invalidPriceMessage
                } else {
                    events.add(Event(name, description, priceValue, address))
                    navController.navigate("main")
                }
            }) {
                Text(stringResource(R.string.save_event))
            }
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text(stringResource(R.string.close_event))
            }
        }
    }
}