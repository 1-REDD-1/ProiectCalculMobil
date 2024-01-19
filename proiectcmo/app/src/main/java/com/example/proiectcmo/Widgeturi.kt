package com.example.proiectcmo

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampIntroducere (
    modifier: Modifier = Modifier,
    descriere: String,
    valoareData: MutableState<String>,
    tipParola: Boolean = false,
) {
    var customVis: VisualTransformation = VisualTransformation.None
    if (tipParola) {
        customVis = PasswordVisualTransformation('*')
    }

    TextField (
        value = valoareData.value,
        label = {Text(descriere)},
        singleLine = true,
        visualTransformation = customVis,
        onValueChange = {
            textIntrodus: String ->
            valoareData.value = textIntrodus
        },

        modifier = modifier
    )
}

@Composable
fun ButonText (descriere: String, functie: () -> Unit) {
    Button (
        onClick = functie,
        content = {Text(descriere)}
    )
}