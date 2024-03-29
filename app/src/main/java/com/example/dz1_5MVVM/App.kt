package com.example.dz1_5MVVM

import android.app.Application
import com.example.dz1_5MVVM.data.local.preference.PreferenceHelper
import com.example.dz1_5MVVM.data.local.preference.SignUpPreferenceHelper

class App: Application() {

    companion object{
        lateinit var preferenceHelper: PreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        preferenceHelper = PreferenceHelper(applicationContext)
        SignUpPreferenceHelper.unit(this)
    }
}