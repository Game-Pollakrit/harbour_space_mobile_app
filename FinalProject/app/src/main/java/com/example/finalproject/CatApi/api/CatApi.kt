package com.example.finalproject.CatApi.api

import com.example.finalproject.CatApi.data.model.CatItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val CAT_API_KEY = "live_sHRJnsSbVpDuAbhhe0uSgK1S0USIZfy09G5uQXqLUGxqwxPKvPJCyuFMisyBWJKB"

interface CatApi {

  @Headers("x-api-key: $CAT_API_KEY")
  @GET("search")
  fun fetchPhotos() : Call<List<CatItem>>
}