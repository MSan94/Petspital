package com.example.petspital.presenter

import com.example.petspital.base.BasePresenter
import com.example.petspital.base.BaseView
import com.example.petspital.data.network.Item
import com.example.petspital.model.hosp.Hosp

interface BaseContract {
    interface HospView : BaseView{
        fun showLoading() //데이터를 받아서 정제 하는동안 보일 ProgressBar관리하는 함수
        fun hideLoading()
        fun moveActivity()
    }
    interface BoardView : BaseView{

    }


    interface PresenterHosp : BasePresenter<HospView>{
        fun getHospApi()
        fun insertRoomHosp()
        fun showHospList() : List<Item>
    }
}