package com.example.petspital.presenter

import android.os.Handler
import com.example.petspital.model.hosp.HospListData


class MainPresenter : MainContract.Presenter {

    private var mainView : MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        mainView = view
    }

    override fun getHospList() {
        mainView?.showLoading()

        // 1초간 네트워크와 통신하는 척
        Handler().postDelayed({
            val hospList = HospListData.getHospListData() // Model에서 HospList를 전달 받는다
            mainView?.showHospList(hospList) //Model에서 전달받은 데이터를 View에게 전달한다.
            mainView?.hindLoading() //네트워크 통신이 끝났으니 View에 프로그레스바를 숨기도록 요청
        },1000)
    }

    override fun dropView() {
        mainView = null
    }
}