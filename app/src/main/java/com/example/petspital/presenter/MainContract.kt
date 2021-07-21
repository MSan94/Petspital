package com.example.petspital.presenter

import com.example.petspital.base.BasePresenter
import com.example.petspital.base.BaseView

interface MainContract {
    interface  View : BaseView{
//        fun showHospList(hospList : List<Hosp>) //정제한 데이터를 Presenter에서 전달받을 함수
        fun showView()
    }

    interface Presenter : BasePresenter<View>{
        fun getHospList() //Model로 부터 데이터를 받아오기(정제하기) 위한 함수
    }
}