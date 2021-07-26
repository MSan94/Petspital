package com.example.petspital.view.fragment.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.petspital.base.BaseFragment
import com.example.petspital.data.network.Item
import com.example.petspital.databinding.FragmentBoardBinding
import com.example.petspital.databinding.FragmentHosplistBinding
import com.example.petspital.presenter.BaseContract
import com.example.petspital.presenter.BoardPresenter
import com.example.petspital.presenter.HospPresenter
import com.example.petspital.view.adapter.HospAdapter

class BoardFragment : BaseFragment(), BaseContract.BoardView {

    private var fragmentBoardBinding: FragmentBoardBinding? = null
    private lateinit var boardPresenter: BoardPresenter
    private lateinit var binding : FragmentBoardBinding

    override fun showError(error: String) {
    }

    override fun initPresenter() {
        boardPresenter = BoardPresenter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }


}