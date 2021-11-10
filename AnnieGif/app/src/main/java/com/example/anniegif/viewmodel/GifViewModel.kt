package com.example.anniegif.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anniegif.model.Neko
import com.example.anniegif.repo.GifRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GifViewModel : ViewModel() {

    private val _gifs = MutableLiveData<List<Neko>>()
    val gifs: LiveData<List<Neko>> get() = _gifs

    fun getImages(gifType: String, amount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                GifRepo.getImages(gifType, amount).url?.let { _gifs.postValue(it) }
            } catch (ex: Exception) {
                Log.d("TAG", "Error: $ex")
            }
        }
    }

}