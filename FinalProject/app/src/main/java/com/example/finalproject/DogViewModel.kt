package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.DogApi.api.DogApiProvider
import com.example.finalproject.DogApi.data.cb.DogResult
import com.example.finalproject.DogApi.data.model.DogItem

private const val TAG = "DogViewModel"
class DogViewModel : ViewModel(), DogResult {

  private val _items = MutableLiveData<List<DogItem>>()
  val items: LiveData<List<DogItem>> = _items

  private val provider by lazy {
    DogApiProvider()
  }

  fun fetchImages() {
    provider.fetchImages(this)
  }

  override fun onDataFetchedSuccess(images: List<DogItem>) {
    Log.d(TAG, "onDataFetchedSuccess | Received ${images.size} images")
    _items.value = images
  }

  override fun onDataFetchedFailed() {
    Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
  }
}