package com.example.finalproject.CatApi.api

import com.example.finalproject.CatApi.data.cb.CatResult
import com.example.finalproject.CatApi.data.model.CatItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val BASE_URL = "https://api.thecatapi.com/v1/images/"

class CatApiProvider {
  private val retrofit by lazy {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(client)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
      .create<CatApi>()
  }

  fun fetchImages(cb: CatResult) {
    retrofit.fetchPhotos().enqueue(object : Callback<List<CatItem>> {
      override fun onResponse(
        call: Call<List<CatItem>>,
        response: Response<List<CatItem>>
      ) {
        if (response.isSuccessful && response.body() != null) {
          cb.onDataFetchedSuccess(response.body()!!)
        } else {
          cb.onDataFetchedFailed()
        }
      }

      override fun onFailure(call: Call<List<CatItem>>, t: Throwable) {
        cb.onDataFetchedFailed()
      }
    })
  }
}

