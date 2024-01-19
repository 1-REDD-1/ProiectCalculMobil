package com.example.proiectcmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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

@Composable
fun AplicatiaMea () {
    val numeUtilizator: MutableState<String> = remember {mutableStateOf("")}
    val parolaUtilizator: MutableState<String> = remember {mutableStateOf("")}


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


        CampIntroducere (
            descriere = "Nume utilizator",
            valoareData = numeUtilizator,
            modifier = Modifier.padding(PaddingValues(bottom = 8.dp))
        )

        CampIntroducere (
            descriere = "Parola utilizator",
            valoareData = parolaUtilizator,
            tipParola = true,
            modifier = Modifier.padding(PaddingValues(bottom = 16.dp))
        )

        ButonText(descriere = "Login") {
            println("Nume de utilizator: " + numeUtilizator.value)

            var notita: Notita?
            val serviciuApi = ApiClient.apiService
            val call = serviciuApi.getNotitaById(1)
            println(RetrofitClient.retrofit.baseUrl())
            println(call.request().url())

            call.enqueue(object : Callback<Notita?> {
                override fun onResponse(call: Call<Notita?>, response: Response<Notita?>) {
                    if (response.isSuccessful) {
                        notita = response.body()
                        if (notita != null) {
                            println(notita!!.titlu)
                        } else {
                            println("Nu exista notita cu id-ul specificat!")
                        }
                    } else {
                        println(response.isSuccessful)
                        println(response.errorBody())
                        println(response.raw().message())
                        println(response.raw().code())
                    }
                }

                override fun onFailure(call: Call<Notita?>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }
}