package com.example.petspital.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.petspital.R
import com.example.petspital.base.BaseActivity
import com.example.petspital.databinding.ActivityInitBinding
import com.example.petspital.presenter.InitContract
import com.example.petspital.presenter.InitPresenter

class InitActivity : BaseActivity(), InitContract.View {

    private lateinit var binding : ActivityInitBinding
    private lateinit var initPresenter : InitPresenter // MainActivity와 1:1 대응하는 MainPresenter를 연결시켜주기 위한 초기화 지연 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initPresenter.takeView(this)

        binding.btnGuestLogin.setOnClickListener { clickBtnEvent(binding.btnGuestLogin) }


//        AppDatabase.getInstance(this)?.let { initPresenter.initRoomHosp(it.hospDao()) }
    }

    override fun initPresenter() {
        initPresenter = InitPresenter()
    }


    override fun moveActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    override fun clickBtnEvent(btnId : AppCompatButton) {
        when(btnId){
            binding.btnGuestLogin -> {
                moveActivity()
            }
        }
    }

    override fun showError(error: String) {

    }



}