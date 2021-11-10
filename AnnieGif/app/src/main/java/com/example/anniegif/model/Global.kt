package com.example.anniegif.model

import android.app.Application
import android.graphics.drawable.Drawable

class Global :Application() {
    companion object{@JvmField
    var gtype : String = "hug"
    lateinit var imageD : Drawable}
}