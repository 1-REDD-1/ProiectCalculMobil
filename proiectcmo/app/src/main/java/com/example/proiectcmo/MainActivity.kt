package com.example.proiectcmo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box (
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AplicatiaMea()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AplicatiaMea () {
//    val numeUtilizator: MutableState<String> = remember {mutableStateOf("")}
//    val parolaUtilizator: MutableState<String> = remember {mutableStateOf("")}

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Notepad", style = TextStyle (
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(12.0F, TextUnitType.Em)
            ),

            modifier = Modifier.padding(bottom = 32.dp),
        )


//        CampIntroducere (
//            descriere = "Nume utilizator",
//            valoareData = numeUtilizator,
//            modifier = Modifier.padding(PaddingValues(bottom = 8.dp))
//        )
//
//        CampIntroducere (
//            descriere = "Parola utilizator",
//            valoareData = parolaUtilizator,
//            tipParola = true,
//            modifier = Modifier.padding(PaddingValues(bottom = 16.dp))
//        )

        ButonText(descriere = "Intrare") {
            var notite: List<Notita>? = null
            val serviciuApi = ApiClient.apiService
            val call = serviciuApi.getNotite()
            val intent = Intent(context, SelectareNotita::class.java)

            call.enqueue(object : Callback<List<Notita>?> {
                override fun onResponse(call: Call<List<Notita>?>, response: Response<List<Notita>?>) {
                    if (response.isSuccessful) {
                        notite = response.body()
                        val arrayNotite: ArrayList<Notita> = arrayListOf()

                        notite?.forEach { notita: Notita -> arrayNotite.add(notita) }

                        println(RetrofitClient.retrofit.baseUrl())
                        intent.putExtra("notite", arrayNotite)

                        context.startActivity(intent)
                    } else {
                        println(response.errorBody())
                        println(response.raw().message())
                        println(response.raw().code())
                    }
                }

                override fun onFailure(call: Call<List<Notita>?>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }
}