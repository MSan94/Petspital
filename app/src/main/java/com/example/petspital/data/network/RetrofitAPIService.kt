package com.example.petspital.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPIService {
    @GET("/rest/ulsananimal/getUlsananimalList")
    fun getHops(
        @Query("ServiceKey") ServiceKey: String,
        @Query("numOfRows") numOfRows : String = "80",
//        @Query("pageNo") pageNo : String
    ): Call<XmlResponse>


}