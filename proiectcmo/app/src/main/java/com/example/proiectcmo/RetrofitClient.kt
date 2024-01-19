package com.example.proiectcmo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("{id}")
    fun getNotitaById(@Path("id") notitaId: Int): Call<Notita?>

    @GET("toate")
    fun getNotite(): Call<List<Notita>?>

    @GET("toate")
    fun getNotiteByAutor(@Path("autor") autor: String): Call<List<Notita>?>

    @POST("publica")
    fun postNotita(notita: Notita)
}

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/notita/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}