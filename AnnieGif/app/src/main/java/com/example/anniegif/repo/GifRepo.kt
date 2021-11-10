package com.example.anniegif.repo

import com.example.anniegif.repo.remote.RetrofitInstance

object GifRepo {

    suspend fun getImages(
        path: String, amount: Int
    ) = RetrofitInstance.gifService.getGifs(path, amount)

}

