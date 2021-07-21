package com.example.petspital.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petspital.R
import com.example.petspital.base.BaseActivity
import com.example.petspital.databinding.ActivityMainBinding
import com.example.petspital.presenter.MainContract
import com.example.petspital.presenter.MainPresenter
import com.example.petspital.view.fragment.hosp.HospListFragment

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainPresenter : MainPresenter // MainActivity와 1:1 대응하는 MainPresenter를 연결시켜주기 위한 초기화 지연 변수
    private val hospListFragment by lazy { HospListFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainPresenter.takeView(this) // MainContract.View를 상속받는 Activity가 생성이 되었다는 것을 Presenter에 알려준다.
        mainPresenter.getHospList()
        initBottomNavigation()
        transFragment(hospListFragment)

    }

    fun initItem(){
    }



//    override fun showHospList(hospList: List<Hosp>) {
//    }



    /**
     * 화면 컴텐츠 visible
     */
    override fun showView() {
        binding.constraintMain.visibility = View.VISIBLE
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




    private fun initBottomNavigation(){
        binding.bottomNavigationMenu.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item_Hosp -> transFragment(hospListFragment)
                }
                true
            }
        }
    }

    private fun transFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main, fragment)
            .commit()
    }


}