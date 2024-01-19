package com.example.proiectcmo

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

class EditareNotite : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box (
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ContinutEditareNotite()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContinutEditareNotite() {
    val continutText: MutableState<String> = remember {mutableStateOf("")}

    val context = LocalContext.current
    val activity = context.findActivity()
    val intent = activity?.intent

    val notita: Notita = intent?.getParcelableExtra<Notita>("notita")!!
    continutText.value = notita.continut

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Editare",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = TextUnit(5.0F, TextUnitType.Em)
            ),

            modifier = Modifier.padding(bottom = 8.dp),)
        Text(
            notita.titlu,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(6.0F, TextUnitType.Em)
            ),

            modifier = Modifier.padding(bottom = 16.dp),
        )

        EditorMultilinie (
            valoareData = continutText,
            modifier = Modifier.padding(bottom = 32.dp),
        )

        ButonText(descriere = "Salvați editarea") {
            
        }

//        LazyRow (
//
//        )
    }
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
