package com.example.petspital.presenter

import android.os.Handler
import android.util.Log
import androidx.annotation.UiThread
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.petspital.data.network.*
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.URLDecoder


class InitPresenter : InitContract.Presenter {
    private var mainView: InitContract.View? = null
    private lateinit var list: List<Item>

    override fun takeView(view: InitContract.View) {
        mainView = view
    }

    override fun getHospApi() {
    }

    /**
     * Room 초기화
     */
//    @UiThread
//    override fun initRoomHosp(hospDao: HospDao) {
//        this.hospDao = hospDao
//    }

//    override fun insertRoomHosp() {
//        val hospList: MutableList<Hosp> = mutableListOf<Hosp>()
//        for (i in list.indices) {
//            var hosp : Hosp = Hosp(i.toString(),list[i].address,list[i].appDate,list[i].entId,list[i].gugun,list[i].title)
//            hospList.add(hosp)
//        }
//        var uiT = Runnable {
//            for (i in 0 until hospList.size) {
//                Log.d("DBtest", "함")
//                hospDao.insert(hospList[i])
//            }
//        }
//        val thread = Thread(uiT)
//        thread.start()
//    }


    override fun dropView() {
        mainView = null
    }

}