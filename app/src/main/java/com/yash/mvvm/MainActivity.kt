package com.yash.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yash.mvvm.viewmodel.ViewModelQuestion
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var viewModelQuestion: ViewModelQuestion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelQuestion = ViewModelProvider(this)[ViewModelQuestion::class.java]
        viewModelQuestion.getListData()?.observe(this, Observer {

        })

    }
}