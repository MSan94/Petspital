package com.example.petspital.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
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
//        moveActivity()

    }

    override fun initPresenter() {
        initPresenter = InitPresenter()
    }

    override fun showLoading() {
        binding.progressLoading.visibility = View.VISIBLE
        binding.textviewLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressLoading.visibility = View.GONE
        binding.textviewLoading.visibility = View.GONE
    }

    override fun moveActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun showError(error: String) {
    }

}