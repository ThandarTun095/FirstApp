package com.example.firstapp.viewmodel

import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private var count: Int = 0
    fun getCount(): Int = count
    fun setCount(num: Int): Int{
        count = num
        count++
        return count
    }
}