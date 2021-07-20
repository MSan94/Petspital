package com.example.petspital.view.fragment.hosp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petspital.databinding.FragmentHosplistBinding
import com.example.petspital.presenter.MainContract
import com.example.petspital.util.room.entity.Hosp

// http://data.ulsan.go.kr/rest/ulsananimal/getUlsananimalList?ServiceKey=aAYj%2B%2FxzbnIufpdEs6pPdTu7H0Tbve6sEljLAwKe5T4JufmD2S5Rom7CezaN4qeI9GTWGkH7mL%2FpjiFj9Bb5aA%3D%3D&numOfRows=10
class HospListFragment : Fragment(), MainContract.View {

    private var fragmentHosplistBinding: FragmentHosplistBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentHosplistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showLoading() {
    }

    override fun hindLoading() {
    }

    override fun showHospList(hospList: List<Hosp>) {
    }

    override fun showView() {
    }

    override fun showError(error: String) {
    }

    override fun onDestroyView() {
        fragmentHosplistBinding = null
        super.onDestroyView()
    }
}