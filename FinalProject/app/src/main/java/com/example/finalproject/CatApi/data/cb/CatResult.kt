package com.example.finalproject.CatApi.data.cb

import com.example.finalproject.CatApi.data.model.CatItem

interface CatResult {

  fun onDataFetchedSuccess(images: List<CatItem>)

  fun onDataFetchedFailed()
}