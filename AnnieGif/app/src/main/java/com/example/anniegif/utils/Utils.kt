package com.example.anniegif.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.anniegif.R

fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun ImageView.loadUrl(url: String?) {
    Glide.with(this).load(url).error(R.drawable.nope).into(this)
}