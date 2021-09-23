package com.yash.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yash.mvvm.model.Question
import com.yash.mvvm.repository.QuestionListRepository

class ViewModelQuestion: ViewModel() {
var serviceliveData:MutableLiveData<ArrayList<Question>>?=null
    fun getListData():LiveData<ArrayList<Question>>?{
        serviceliveData = QuestionListRepository.getServiceApiCall()
        return serviceliveData
    }

}