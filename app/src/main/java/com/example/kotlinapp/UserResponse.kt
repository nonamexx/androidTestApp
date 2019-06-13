package com.example.kotlinapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Pear on 6/13/2019.
 */
data class UserResponse (
    @SerializedName("total_count") val total_count: Int,
    @SerializedName("incomplete_results") val incomplete_results: Boolean,
    @SerializedName("items") val users: List<User>
)