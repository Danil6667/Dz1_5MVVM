package com.example.dz1_5MVVM.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dz1_5MVVM.R
import com.example.dz1_5MVVM.data.local.preference.SignUpPreferenceHelper
import com.example.dz1_5MVVM.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SignUpPreferenceHelper.unit(requireContext())
        setupListener()
        openSignUp()
    }

    private fun setupListener() = with(binding) {
        btmSign.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etMail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = "Заполните поле"
            } else if (age.isEmpty()) {
                etAge.error = "Заполните поле"
            } else if (email.isEmpty()) {
                etMail.error = "Заполните поле"
            } else if (password.isEmpty()) {
                etPassword.error = "Заполните поле"
            } else {
                viewModel.signUp(name, age.toInt(), email, password)
                findNavController().navigate(R.id.action_signUpFragment_to_userInfoFragment)
            }
        }
    }

    private fun openSignUp() {
        SignUpPreferenceHelper.isSignUp = true
    }
}