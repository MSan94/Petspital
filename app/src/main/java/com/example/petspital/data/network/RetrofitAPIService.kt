package com.example.petspital.data.network

import com.example.petspital.model.hosp.Hosp
import com.example.petspital.model.hosp.HospListData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPIService {
    @GET("/rest/ulsananimal/getUlsananimalList")
    fun getHops(
        @Query("ServiceKey") ServiceKey: String,
        @Query("numOfRows") numOfRows : String = "80"
    ): Call<ResponseBody>

}