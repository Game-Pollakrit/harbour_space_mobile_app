package com.harbourspace.unsplash.data.cb

import com.harbourspace.unsplash.data.model.UnsplashItem

interface UnsplashResult {

  fun onDataFetchedSuccess(images: UnsplashItem)

  fun onDataFetchedFailed()
}