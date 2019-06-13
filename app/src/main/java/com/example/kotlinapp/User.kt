package com.example.kotlinapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Pear on 6/13/2019.
 */
data class User (
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatar_url: String,
    @SerializedName("url") val url: String
)