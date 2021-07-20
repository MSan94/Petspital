package com.example.petspital.presenter

import android.os.Handler
import android.util.Log
import android.util.Xml
import androidx.annotation.XmlRes
import com.example.petspital.data.network.*
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.net.URLDecoder


class InitPresenter : InitContract.Presenter {
    private var idx = 1;
    private var mainView: InitContract.View? = null

    override fun takeView(view: InitContract.View) {
        mainView = view
    }

    override fun getHospApi() {

        Log.d("테스트", "시작");
        mainView?.showLoading()

        // 1초간 네트워크와 통신하는 척
        Handler().postDelayed({
            mainView?.hideLoading() //네트워크 통신이 끝났으니 View에 프로그레스바를 숨기도록 요청
            mainView?.moveActivity()
        }, 3000)

        /**
         * 동물병원 정보 추출
         */
        val retrofit = Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(
                TikXmlConverterFactory.create(
                    TikXml.Builder().exceptionOnUnreadXml(false).build()
                )
            )
            .client(OkHttpClient())
            .build()
        val retrofitService = retrofit.create(RetrofitAPIService::class.java)
        retrofitService.getHops(
            URLDecoder.decode(Param.SERVICEKEY),
            Param.NUMOFROWS,
        )
            .enqueue(object : Callback<XmlResponse> {
                override fun onResponse(
                    call: Call<XmlResponse>,
                    response: Response<XmlResponse>
                ) {
                    /**
                     *  Data 가공
                     */
                    val res: XmlResponse? = response.body()
                    val body: Body? = res?.body
                    val items: List<Items>? = body?.data
                    val list: List<Item>? = items?.get(0)?.item
                    for (i in 0..list?.size!!) {
                        Log.d("TestApp", "${list[i].toString()}")
                    }
                }

                override fun onFailure(call: Call<XmlResponse>, t: Throwable) {
                    Log.d("TestApp", t.toString())
                    Log.d("Test", call.toString())
                }
            })

    }


    override fun dropView() {
    }

}
