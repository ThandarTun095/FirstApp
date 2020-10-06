package com.example.firstapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_viewmodel_acitivity.*

class ViewmodelAcitivity : AppCompatActivity() {

    //shared preference
    val sharedFile = "SHARE_PREFERENCE"
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel_acitivity)

        var countViewModel = ViewModelProvider(this) //create object viewmodel
            .get(CountViewModel::class.java)
//shared preference
        sharedPreferences = this.getSharedPreferences(sharedFile,
        Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
        var storedCount = sharedPreferences?.getInt("COUNT", 0)
        txtVMCount.text = storedCount.toString()

        btnVMCount.setOnClickListener {
            var count = txtVMCount.text.toString().toInt()
            countViewModel.setCount(count)
            txtVMCount.text = countViewModel.getCount().toString()

        }

    }
//shared preference  //put //set
    override fun onPause() {
        super.onPause()
        editor?.putInt("COUNT", txtVMCount.text.toString().toInt())
        editor?.apply()
    }

}