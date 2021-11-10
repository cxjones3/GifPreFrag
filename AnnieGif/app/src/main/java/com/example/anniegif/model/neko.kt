package com.example.anniegif.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class neko( var url : List<nekos>?)


@JsonClass(generateAdapter = true)
data class nekos(
    val url : String?,
    @Json(name = "anime_name")
    val animeName : String?,
)

