package com.example.finalproject.DogApi.data.cb

import com.example.finalproject.DogApi.data.model.DogItem

interface DogResult {

  fun onDataFetchedSuccess(images: List<DogItem>)

  fun onDataFetchedFailed()
}