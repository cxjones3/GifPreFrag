package com.example.anniegif.repo.remote

import com.example.anniegif.R
import com.example.anniegif.model.Global
import com.example.anniegif.model.neko
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface GifService {
    @GET("api/v1/{endpoint}")
    suspend fun getGifs(@Path("endpoint") endpoint: String, @Query("amount") amount : Int): Response<neko>



    /*@GET("api/v1/")
    suspend fun getGifs(
        @Query("amount") amount : Int?
        ): Response<neko>*/
}