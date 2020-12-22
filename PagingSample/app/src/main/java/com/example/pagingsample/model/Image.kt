package com.example.pagingsample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("user")
    @Expose
    val user: String,

    @SerializedName("pageURL")
    @Expose
    val pageURL: String,

    @SerializedName("previewURL")
    @Expose
    val previewURL: String,

    @SerializedName("largeImageURL")
    @Expose
    val largeImageURL: String,

    @SerializedName("views")
    @Expose
    val views: Int,

    @SerializedName("downloads")
    @Expose
    val downloads: Int,

    @SerializedName("favorites")
    @Expose
    val favorites: Int,

    @SerializedName("likes")
    @Expose
    val likes: Int
)