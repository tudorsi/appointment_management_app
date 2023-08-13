package com.example.dynamic_appointment_application.ui.login

import android.os.Bundle
import com.example.dynamic_appointment_application.R
import com.example.dynamic_appointment_application.base.BaseFragment
import com.example.dynamic_appointment_application.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel: LoginViewModel by viewModel()
    override fun FragmentLoginBinding.onViewCreated(savedInstanceState: Bundle?) {
        setStatusBarColor(R.color.primary_alabaster, true)
        loginViewModel.loginStatusLiveData.observe(viewLifecycleOwner) {
            showToast(it.toString())
            navigate(R.id.action_fragment_login_to_fragment_dashboard)
        }
        loginButton.setOnClickListener {
            loginViewModel.login(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
    }
}