package com.example.petspital.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.petspital.R
import com.example.petspital.base.BaseActivity
import com.example.petspital.databinding.ActivityMainBinding
import com.example.petspital.model.hosp.Hosp
import com.example.petspital.presenter.MainContract
import com.example.petspital.presenter.MainPresenter

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var binding : ActivityMainBinding
    // MainActivity와 1:1 대응하는 MainPresenter를 연결시켜주기 위한 초기화 지연 변수
    private lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // MainContract.View를 상속받는 Activity가 생성이 되었다는 것을 Presenter에 알려준다.
        mainPresenter.takeView(this)
    }

    override fun showLoading() {
        // 프로그래스바 visible
    }

    override fun hindLoading() {
        // 프로그래스바 visible
    }

    override fun showHospList(hospList: List<Hosp>) {
    }

    override fun showError(error: String) {
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
    }

    // BaseActivity에서 Activity가 생성이되면 해당 Activity에 Presenter를 초기화 시켜준다.
    override fun initPresenter() {
        mainPresenter = MainPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }
}