package com.example.anniegif.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anniegif.R
import com.example.anniegif.adapter.GifAdapter
import com.example.anniegif.databinding.ActivityMainBinding
import com.example.anniegif.databinding.ItemImageBinding
import com.example.anniegif.model.Global
import com.example.anniegif.viewmodel.GifViewModel

class AnnieGifListActivity : AppCompatActivity() {

    private val binding2 by lazy{ItemImageBinding.inflate(layoutInflater)}
    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val viewModel by viewModels<GifViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("AnnieActivity", "before")
        binding.rvImages.adapter = GifAdapter()

        val type = getIntent().getStringExtra("giftype")
        Log.d("AnnieActivity", type.toString())

        viewModel.getImages(type.toString(), 20)



        viewModel.gifs.observe(this) {
            // Here is where your will get the result
            Log.d("AnnieActivity", "onCreate: $it")
           // (findViewById<RecyclerView>(R.id.rv_images).adapter as GifAdapter).updateUrls(it)
            (binding.rvImages.adapter as GifAdapter).updateUrls(it)
            (binding.rvImages.layoutManager as GridLayoutManager).spanCount = 2

        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun goFull(view: View) {
        val url = binding2.ivImage.getTooltipText().toString()
        Global.imageD = binding2.ivImage.drawable
        //binding2.ivImage.imageURI
        val intent = Intent(this,FullScreenGifActivity::class.java)
        intent.putExtra("fullscreen",url)
        startActivity(intent)
        Log.d("Annie",url.toString())
    }


}