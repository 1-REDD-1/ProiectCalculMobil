package com.example.proiectcmo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notita (
    @SerializedName("titlu") val titlu: String,
    @SerializedName("continut") val continut: String,
    @SerializedName("autor") val autor: String,
    @SerializedName("id") val id: Int,
) : Parcelable