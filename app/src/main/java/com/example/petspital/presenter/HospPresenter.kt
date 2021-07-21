package com.example.petspital.presenter

import android.os.Handler
import android.util.Log
import androidx.annotation.UiThread
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.petspital.data.network.*
import com.example.petspital.model.hosp.Hosp
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.URLDecoder


class HospPresenter : BaseContract.PresenterHosp {

//    private lateinit var hospDao: HospDao
    private lateinit var list: List<Item>
    private var mainView: BaseContract.HospView? = null

    override fun getHospApi(){
        /**
         * 동물병원 정보 추출
         */
        val retrofit = Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
            .client(OkHttpClient())
            .build()
        val retrofitService = retrofit.create(RetrofitAPIService::class.java)
        retrofitService.getHops(URLDecoder.decode(Param.SERVICEKEY), Param.NUMOFROWS,)
            .enqueue(object : Callback<XmlResponse> {
                override fun onResponse(call: Call<XmlResponse>, response: Response<XmlResponse>) {
                    /** Data 가공 **/
                    val res: XmlResponse? = response.body()
                    val body: Body? = res?.body
                    val items: List<Items>? = body?.data
                    list = items?.get(0)?.item!!
                }
                override fun onFailure(call: Call<XmlResponse>, t: Throwable) {
                }
            })
    }

    override fun insertRoomHosp() {
    }

    override fun showHospList()  : List<Item>{
        return list
    }

    override fun takeView(view: BaseContract.HospView) {
        mainView = view
    }

    override fun dropView() {
    }


}