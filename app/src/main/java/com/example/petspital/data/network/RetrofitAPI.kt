package com.example.petspital.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAPI {

    fun provideRetrofitApiService(retrofit: Retrofit): RetrofitAPIService {
        return retrofit.create(RetrofitAPIService::class.java)
    }

    fun provideGson(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        )
    }

    fun provideHospRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}