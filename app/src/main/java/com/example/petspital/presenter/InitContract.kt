package com.example.petspital.presenter

import com.example.petspital.base.BasePresenter
import com.example.petspital.base.BaseView

interface InitContract {
    interface  View : BaseView{
        fun moveActivity()
    }

    interface Presenter : BasePresenter<View>{
        fun getHospApi()
//        fun initRoomHosp(hospDao : HospDao)
//        fun insertRoomHosp()
    }
}