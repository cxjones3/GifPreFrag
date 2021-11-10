package com.example.anniegif.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.anniegif.adapter.GifAdapter
import com.example.anniegif.databinding.ActivityMainBinding
import com.example.anniegif.model.Neko
import com.example.anniegif.utils.BundleKey
import com.example.anniegif.utils.openActivity
import com.example.anniegif.viewmodel.GifViewModel

class AnnieGifListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<GifViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()

        val type = intent.extras?.getString(BundleKey.TYPE)

        if (type != null) {
            viewModel.getImages(type, 20)
            viewModel.gifs.observe(this) {
                // Here is where your will get the result
                Log.d("AnnieActivity", "onCreate: $it")
                (binding.rvImages.adapter as GifAdapter).updateUrls(it)
            }
        } else Toast.makeText(this, "No Type Selected", Toast.LENGTH_SHORT).show().also {
            finish()
        }

    }

    private fun initViews() = with(binding) {
        rvImages.adapter = GifAdapter(::goFull)
    }

    fun goFull(neko: Neko) {
        openActivity(FullScreenGifActivity::class.java) { putString(BundleKey.URL, neko.url) }
    }
}