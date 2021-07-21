package com.example.petspital.view.fragment.hosp

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petspital.base.BaseFragment
import com.example.petspital.data.network.Item
import com.example.petspital.databinding.FragmentHosplistBinding
import com.example.petspital.presenter.BaseContract
import com.example.petspital.presenter.HospPresenter
import com.example.petspital.presenter.MainContract
import com.example.petspital.presenter.MainPresenter
import com.example.petspital.view.adapter.HospAdapter

class HospListFragment : BaseFragment(), BaseContract.HospView {

    private var fragmentHosplistBinding: FragmentHosplistBinding? = null
    private lateinit var hospPresenter: HospPresenter
    private lateinit var hospAdapter: HospAdapter
    private lateinit var hospList : List<Item>
    private lateinit var binding : FragmentHosplistBinding

    override fun initPresenter() {
        hospPresenter = HospPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHosplistBinding.inflate(inflater, container, false)
        Log.d("TestFrag","테스트시작11")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        hospPresenter.takeView()
        hospAdapter = HospAdapter()
        hospPresenter.getHospApi()
        showLoading()

        Handler().postDelayed({
            hideLoading()
            hospList = hospPresenter.showHospList()
            hospAdapter.submitList(hospList)
            binding.HosprecyclerView.layoutManager = LinearLayoutManager(context)
            binding.HosprecyclerView.adapter = hospAdapter
        }, 3000)

    }

    override fun showLoading() {
        binding.progressLoading.visibility = View.VISIBLE
        binding.textviewLoading.visibility = View.VISIBLE
        binding.linearLayoutContent.visibility = View.GONE
    }

    override fun hideLoading() {
        binding.progressLoading.visibility = View.GONE
        binding.textviewLoading.visibility = View.GONE
        binding.linearLayoutContent.visibility = View.VISIBLE
    }

    override fun moveActivity() {
    }

    override fun showError(error: String) {
    }

    override fun onDestroyView() {
        fragmentHosplistBinding = null
        super.onDestroyView()
    }

}