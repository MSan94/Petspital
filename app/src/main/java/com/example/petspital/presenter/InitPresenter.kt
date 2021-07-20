package com.example.petspital.presenter

import android.os.Handler
import android.util.Log
import androidx.annotation.UiThread
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.petspital.data.network.*
import com.example.petspital.util.room.dao.HospDao
import com.example.petspital.util.room.entity.Hosp
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.URLDecoder


class InitPresenter : InitContract.Presenter {
    private var idx = 1;
    private var mainView: InitContract.View? = null
    private lateinit var list: List<Item>
    private lateinit var hospDao: HospDao

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
//            insertRoomHosp()
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
                    list = items?.get(0)?.item!!
                }

                override fun onFailure(call: Call<XmlResponse>, t: Throwable) {
                }
            })
    }

    /**
     * Room 초기화
     */
    @UiThread
    override fun initRoomHosp(hospDao: HospDao) {
        this.hospDao = hospDao
    }

    override fun insertRoomHosp() {
        val hospList: MutableList<Hosp> = mutableListOf<Hosp>()
        for (i in list.indices) {
            var hosp : Hosp = Hosp(i.toString(),list[i].address,list[i].appDate,list[i].entId,list[i].gugun,list[i].title)
            hospList.add(hosp)
        }
        var uiT = Runnable {
            for (i in 0 until hospList.size) {
                Log.d("DBtest", "함")
                hospDao.insert(hospList[i])
            }
        }
        val thread = Thread(uiT)
        thread.start()
    }


    override fun dropView() {
        mainView = null
    }

}