package com.example.anniegif.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anniegif.model.neko
import com.example.anniegif.model.nekos
import com.example.anniegif.repo.GifRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GifViewModel : ViewModel() {

    private val _gifs = MutableLiveData<List<nekos>>()
    val gifs: LiveData<List<nekos>> get() = _gifs

    fun getImages(gifType: String, amount :Int) {
        Log.d("vm","here")
        viewModelScope.launch(Dispatchers.IO) {
            try{
            val response = GifRepo.getImages(gifType,amount)
            val list = if (response.isSuccessful && !response.body()?.url.isNullOrEmpty())
            response.body()?.url
            else {
                Log.d("vm","erreor")
                listOf("ERROR")
            }
            list?.let { urls -> _gifs.postValue(urls as List<nekos>) }
            Log.d("vm","here2")
            }
            catch (ex: Exception){
                "Error: $ex"
            }
        }
    }

}