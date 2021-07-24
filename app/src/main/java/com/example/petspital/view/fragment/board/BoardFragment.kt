package com.example.petspital.view.fragment.board

import androidx.fragment.app.Fragment
import com.example.petspital.presenter.BaseContract

class BoardFragment : Fragment(), BaseContract.BoardView {
    override fun showError(error: String) {
    }
}