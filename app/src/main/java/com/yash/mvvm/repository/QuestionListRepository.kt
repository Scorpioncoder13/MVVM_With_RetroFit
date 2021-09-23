package com.yash.mvvm.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.yash.mvvm.model.Question
import com.yash.mvvm.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type


object QuestionListRepository {
    var servicesettergetter = MutableLiveData<ArrayList<Question>>()
    fun getServiceApiCall(): MutableLiveData<ArrayList<Question>> {
        val call = RetrofitClient.apiInterface.getServices()
        call.enqueue(object : Callback<List<Question>> {
            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Question>>,
                response: Response<List<Question>>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                try {
                    val list:ArrayList<Question> = ArrayList()
                    for (i in 0 until response.body()?.size!!){
                        list.add(Question(response.body()!![i].userId,response.body()!![i].id,response.body()!![i].title))
                    }
                    servicesettergetter.value = list
                } catch (e: Exception) {
                    Log.d("yash", "onResponse: "+e.message)
                }

            }
        })
        return servicesettergetter
    }
}