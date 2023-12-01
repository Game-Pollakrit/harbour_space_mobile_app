package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.CatApi.api.CatApiProvider
import com.example.finalproject.CatApi.data.cb.CatResult
import com.example.finalproject.CatApi.data.model.CatItem

private const val TAG = "CatViewModel"
class CatViewModel : ViewModel(), CatResult {

    private val _items = MutableLiveData<List<CatItem>>()
    val items: LiveData<List<CatItem>> = _items

    private val provider by lazy {
        CatApiProvider()
    }

    fun fetchImages() {
        provider.fetchImages(this)
    }

    override fun onDataFetchedSuccess(images: List<CatItem>) {
        Log.d(TAG, "onDataFetchedSuccess | Received ${images.size} images")
        _items.value = images
    }

    override fun onDataFetchedFailed() {
        Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
    }
}