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


class HospPresenter : BaseContract.PresenterHosp {

    private lateinit var hospDao: HospDao

    override fun getHospApi() {
    }

    override fun initRoomHosp(hospDao: HospDao) {
        this.hospDao = hospDao
    }

    override fun insertRoomHosp() {
    }

    override fun takeView(view: BaseContract.HospView) {
    }

    override fun dropView() {
    }


}