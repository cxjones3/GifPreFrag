package com.example.anniegif.repo.remote

import com.example.anniegif.model.Nekos
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GifService {

    @GET("api/v1/{endpoint}")
    suspend fun getGifs(
        @Path("endpoint") endpoint: String, @Query("amount") amount: Int
    ): Nekos

}