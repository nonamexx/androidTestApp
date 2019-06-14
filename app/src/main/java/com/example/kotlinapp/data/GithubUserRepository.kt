package com.example.kotlinapp.data

import com.example.kotlinapp.service.Service

/**
 * Created by Pear on 6/14/2019.
 */
class GithubUserRepository(private val service: Service): GithubUserDataSource {
    override fun searchUserInGithub(username: String) = service.searchUser(username)
}