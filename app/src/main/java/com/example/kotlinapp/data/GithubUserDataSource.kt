package com.example.kotlinapp.data

import com.example.kotlinapp.UserResponse
import io.reactivex.Single
import retrofit2.Response

/**
 * Created by Pear on 6/14/2019.
 */
interface GithubUserDataSource {
    fun searchUserInGithub(username: String): Single<Response<UserResponse>>
}