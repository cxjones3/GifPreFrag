package com.example.anniegif.repo

import com.example.anniegif.model.neko
import com.example.anniegif.repo.remote.RetrofitInstance
import com.squareup.moshi.JsonClass
import retrofit2.Call
import retrofit2.Response

object GifRepo {

        suspend fun getImages(path: String, amount : Int): Response<neko> {
            return RetrofitInstance.gifService.getGifs(path, amount)
        }

}

