package com.example.proiectcmo

import com.google.gson.annotations.SerializedName

data class Notita (
    @SerializedName("titlu") val titlu: String,
    @SerializedName("continut") val continut: String,
    @SerializedName("autor") val autor: String,
)