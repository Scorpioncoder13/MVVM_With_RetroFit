package com.yash.mvvm.retrofit

import com.yash.mvvm.model.Question
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("albums")
    fun getServices() : Call<List<Question>>

}