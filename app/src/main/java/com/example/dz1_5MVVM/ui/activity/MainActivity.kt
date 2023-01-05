package com.example.dz1_5MVVM.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dz1_5MVVM.R

import com.example.dz1_5MVVM.data.local.preference.SignUpPreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHostFragment.navController

        when (SignUpPreferenceHelper.isSignUp) {
            true -> {
                navController.navigate(R.id.userInfoFragment)
            }
            else -> {
                navController.navigate(R.id.signUpFragment)
            }
        }
    }
}