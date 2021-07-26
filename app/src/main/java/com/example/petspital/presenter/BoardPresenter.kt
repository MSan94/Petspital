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


class BoardPresenter : BaseContract.PresenterBoard {

//    private lateinit var hospDao: HospDao
    private lateinit var list : List<Item>
    private var mainView: BaseContract.HospView? = null
    override fun takeView(view: BaseContract.BoardView) {

    }

    override fun dropView() {
    }


}