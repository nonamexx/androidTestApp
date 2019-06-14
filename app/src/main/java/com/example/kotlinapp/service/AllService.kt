package com.example.kotlinapp.service

import com.example.kotlinapp.UserResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pear on 6/13/2019.
 */
interface AllService {
    @GET("search/users")
    fun searchUser(@Query("q") q: String?): Single<Response<UserResponse>>
}