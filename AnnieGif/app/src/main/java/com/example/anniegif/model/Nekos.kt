package com.example.anniegif.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Nekos(var url: List<Neko>?)


