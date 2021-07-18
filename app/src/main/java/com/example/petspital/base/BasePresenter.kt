package com.example.petspital.base

interface BasePresenter<T> {

    fun takeView(view : T)
    fun dropView()

}