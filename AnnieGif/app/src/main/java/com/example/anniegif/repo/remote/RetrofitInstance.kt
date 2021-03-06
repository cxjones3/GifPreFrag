package com.example.anniegif.repo.remote

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://nekos.best")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val gifService: GifService = retrofit.create(GifService::class.java)
}