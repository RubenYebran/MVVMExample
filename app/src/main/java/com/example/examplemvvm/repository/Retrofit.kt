package com.example.examplemvvm.repository

import com.example.examplemvvm.application.ApplicationConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val webservice: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(ApplicationConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}