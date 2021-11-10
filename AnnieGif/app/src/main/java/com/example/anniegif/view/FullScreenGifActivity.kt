package com.example.anniegif.view

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.example.anniegif.R
import com.example.anniegif.databinding.FullLayoutBinding
import com.example.anniegif.model.Global


class FullScreenGifActivity : AppCompatActivity() {

    private val binding by lazy{FullLayoutBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Full sCren", "here")
        setContentView(binding.root)

        binding.closeBtn.setOnClickListener(){
            this.finish()
        }

        val imageUrl = getIntent().getStringExtra("fullscreen")?.toString()
        if (imageUrl.toString() == "null") {
            val resources: Resources = resources
            binding.ivFull.setImageDrawable(resources.getDrawable(com.example.anniegif.R.drawable.nope))
            val image = com.example.anniegif.R.drawable.nope
            binding.ivFull.setImageResource(image)
            Log.d("Full sCren fail",imageUrl.toString())

        } else {
            Log.d("Full sCren comp",imageUrl.toString())
           // binding.ivFull.setImageResource(Global.imageD)
            Glide.with(binding.ivFull).load(imageUrl).into(binding.ivFull)
        }



    }



}