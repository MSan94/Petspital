package com.example.petspital.view

import android.os.Bundle
import com.example.petspital.base.BaseActivity
import com.example.petspital.databinding.ActivityInitBinding
import com.example.petspital.databinding.ActivityMainBinding
import com.example.petspital.presenter.InitContract
import com.example.petspital.presenter.InitPresenter
import com.example.petspital.presenter.MainPresenter

class InitActivity : BaseActivity(), InitContract.View {

    private lateinit var binding : ActivityInitBinding
    private lateinit var initPresenter : InitPresenter // MainActivity와 1:1 대응하는 MainPresenter를 연결시켜주기 위한 초기화 지연 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initPresenter.takeView(this)
        initPresenter.getHospApi()

    }

    override fun initPresenter() {
        initPresenter = InitPresenter()
    }

    override fun showError(error: String) {
    }
}