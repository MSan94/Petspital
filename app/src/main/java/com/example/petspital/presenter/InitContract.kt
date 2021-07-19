package com.example.petspital.presenter

import com.example.petspital.base.BasePresenter
import com.example.petspital.base.BaseView
import com.example.petspital.model.hosp.Hosp

interface InitContract {
    interface  View : BaseView{

    }

    interface Presenter : BasePresenter<View>{
        fun getHospApi();
    }
}