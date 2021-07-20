package com.example.petspital.presenter

import android.os.Handler


class MainPresenter : MainContract.Presenter {

    private var mainView : MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        mainView = view
    }

    override fun getHospList() {

    }

    override fun dropView() {
        mainView = null
    }
}


