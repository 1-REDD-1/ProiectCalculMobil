package com.example.proiectcmo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.proiectcmo.ui.theme.ProiectCMOTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectareNotita : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box (
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ContinutSelectareNotita()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContinutSelectareNotita() {
    var notite: List<Notita>? = null

    val context = LocalContext.current
    val activity = context.findActivity()
    val intentActivitateAnterioara = activity?.intent
    val intent = Intent(context, EditareNotite::class.java)

    notite = intentActivitateAnterioara?.getParcelableArrayListExtra("notite")
    println(notite?.size)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selectați o notița din lista dată de notițe")

        LazyColumn {
            items(notite!!) {
                NotitaCard(notita = it, intent, context)
            }
        }
    }
}

@Composable
fun NotitaCard (notita: Notita, intent: Intent, context: Context) {
    ButonText(descriere = notita.titlu, functie = {
        intent.putExtra("notita", notita)

        context.startActivity(intent)
    })
}