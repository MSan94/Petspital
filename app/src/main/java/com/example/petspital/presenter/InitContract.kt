package com.example.petspital.presenter

import com.example.petspital.base.BasePresenter
import com.example.petspital.base.BaseView
import com.example.petspital.model.hosp.Hosp

interface InitContract {
    interface  View : BaseView{
        fun showLoading() //데이터를 받아서 정제 하는동안 보일 ProgressBar관리하는 함수
        fun hideLoading()
        fun moveActivity()
    }

    interface Presenter : BasePresenter<View>{
        fun getHospApi()
    }
}