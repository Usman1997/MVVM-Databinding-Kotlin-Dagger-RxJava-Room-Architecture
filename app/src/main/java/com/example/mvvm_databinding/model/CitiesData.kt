package com.example.mvvm_databinding.model

import com.google.gson.annotations.SerializedName

data class CitiesData (
    @SerializedName("id_city")
    val id: Int,
    @SerializedName("name_en")
    val name_en: String,
    @SerializedName("name_ar")
    val name_ar: String,
    @SerializedName("id_country")
    val id_country: Int,
    @SerializedName("active")
    val active: Int,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("updated_at")
    val updated_at: String

)