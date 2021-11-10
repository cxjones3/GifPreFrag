package com.example.anniegif.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anniegif.R
import com.example.anniegif.databinding.ActivityMainBinding
import androidx.activity.viewModels
import com.example.anniegif.adapter.GifAdapter
import com.example.anniegif.databinding.StartActivityBinding
import com.example.anniegif.model.Global
import com.example.anniegif.model.Global.Companion.gtype
import com.example.anniegif.viewmodel.GifViewModel
import java.text.FieldPosition

class MainActivity : AppCompatActivity(){

    private val binding by lazy { StartActivityBinding.inflate(layoutInflater) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "pass cv")
        setContentView(binding.root)

        binding.typeBtn.setOnClickListener(){
            Global.gtype = binding.typeChooser.selectedItem.toString()
            Log.d("MainActivity", "spinner: " + gtype)
            val intent = Intent(this,AnnieGifListActivity::class.java)
            intent.putExtra("giftype", Global.gtype)
            Log.d("MainActivity", "below")
            startActivity(intent);

    }



    }

}