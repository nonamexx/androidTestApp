package com.example.kotlinapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinapp.service.AllService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Pear on 6/13/2019.
 */
class GithubUserViewModel @Inject constructor() : ViewModel(){

    private val compositeDisposable = CompositeDisposable()
    val userDataLiveData = MutableLiveData<UserResponse>()
    val errorLiveData = MutableLiveData<Boolean>()

//    fun getNameList(): List<String> {
//        val nameList = listOf("Cupcake",
//            "Donut",
//            "Eclair",
//            "Froyo",
//            "Gingerbread",
//            "Honeycomb",
//            "Ice Cream Sandwich",
//            "Jelly Bean",
//            "Kitkat",
//            "Lollipop",
//            "Marshmallow",
//            "Nougat")
//        return nameList
//    }
//
//    fun getTheName() {
//
//    }

//    private var retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("https://api.github.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .build()
//
//    var service: AllService = retrofit.create(AllService::class.java)

    @Inject
    lateinit var githubService: AllService

    fun searchUserInGithub(user: String?) {

        githubService.searchUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy ({
                errorLiveData.postValue(true)
            }, {
                if (it.isSuccessful) {
                    userDataLiveData.postValue(it.body())
                } else {
                    errorLiveData.postValue(true)
                }
            }).also {
                compositeDisposable.add(it)
            }

    }

    override fun onCleared() {
        super.onCleared()

        if (compositeDisposable.size() > 0){
            compositeDisposable.clear()
        }
    }
}