package com.example.petspital.presenter

import android.os.Handler
import android.util.Log
import com.example.petspital.data.network.Param
import com.example.petspital.data.network.RetrofitAPI
import com.example.petspital.data.network.RetrofitAPIService
import com.example.petspital.data.network.Url
import com.example.petspital.model.hosp.Hosp
import com.example.petspital.model.hosp.HospListData
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.net.URLDecoder
import java.util.*


class InitPresenter : InitContract.Presenter {

    private var mainView : InitContract.View? = null

    override fun takeView(view: InitContract.View) {
        mainView = view
    }

    override fun getHospApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitAPIService::class.java)
        retrofitService.getHops(URLDecoder.decode(Param.ServiceKey)).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("Test", "성공")
                response.body()?.let { Log.d("Test", it.string()) }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("Test", "실패")
                Log.d("Test", t.toString())
            }
        })
    }

    override fun dropView() {
    }

}
