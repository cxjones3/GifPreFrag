package com.example.anniegif.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anniegif.databinding.FullLayoutBinding
import com.example.anniegif.utils.BundleKey
import com.example.anniegif.utils.loadUrl

class FullScreenGifActivity : AppCompatActivity() {

    private val binding by lazy { FullLayoutBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        closeBtn.setOnClickListener() { finish() }
        ivFull.loadUrl(intent.extras?.getString(BundleKey.URL))
    }
}