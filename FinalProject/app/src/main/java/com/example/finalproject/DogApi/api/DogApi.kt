package com.example.finalproject.DogApi.api

import com.example.finalproject.DogApi.data.model.DogItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val DOG_API_KEY = "live_CHsoZ81fGW3bnhw86Lst9bRtMQaxTZoH8lZwyyRQoRAdhvhDyyQ9FOPmxDnby52F"

interface DogApi {

  @Headers("x-api-key: $DOG_API_KEY")
  @GET("search")
  fun fetchPhotos() : Call<List<DogItem>>
}