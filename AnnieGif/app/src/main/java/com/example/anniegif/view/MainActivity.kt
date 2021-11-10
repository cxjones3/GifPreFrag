package com.example.anniegif.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anniegif.databinding.StartActivityBinding
import com.example.anniegif.utils.BundleKey
import com.example.anniegif.utils.openActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { StartActivityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        typeBtn.setOnClickListener {
            openActivity(AnnieGifListActivity::class.java) {
                putString(BundleKey.TYPE, typeChooser.selectedItem.toString())
            }
        }
    }
}