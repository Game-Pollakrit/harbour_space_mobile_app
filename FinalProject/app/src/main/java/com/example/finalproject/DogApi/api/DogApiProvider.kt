package com.example.finalproject.DogApi.api

import com.example.finalproject.DogApi.data.cb.DogResult
import com.example.finalproject.DogApi.data.model.DogItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https://api.thedogapi.com/v1/images/"

class DogApiProvider {
  private val retrofit by lazy {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(client)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
      .create<DogApi>()
  }

  fun fetchImages(cb: DogResult) {
    retrofit.fetchPhotos().enqueue(object : Callback<List<DogItem>> {
      override fun onResponse(
        call: Call<List<DogItem>>,
        response: Response<List<DogItem>>
      ) {
        if (response.isSuccessful && response.body() != null) {
          cb.onDataFetchedSuccess(response.body()!!)
        } else {
          cb.onDataFetchedFailed()
        }
      }

      override fun onFailure(call: Call<List<DogItem>>, t: Throwable) {
        cb.onDataFetchedFailed()
      }
    })
  }
}

