package com.example.pagingsample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PixabayResponse(
    @SerializedName("total")
    @Expose
    val total: String?,

    @SerializedName("totalHits")
    @Expose
    val totalHits: String?,

    @SerializedName("hits")
    @Expose
    val hits: List<Image>
)