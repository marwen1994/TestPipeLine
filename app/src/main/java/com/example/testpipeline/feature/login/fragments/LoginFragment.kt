package com.example.testpipeline.feature.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.testpipeline.R
import com.example.testpipeline.databinding.FragmentLoginBinding
import com.example.testpipeline.databinding.FragmentRegisterBinding
import com.example.testpipeline.feature.food.MainActivity
import com.example.testpipeline.feature.login.LoginRegisterActivity

class LoginFragment : Fragment() {
     private lateinit var binding :FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()

    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    private fun handleNavigation() {

        binding.navigateToRegister.setOnClickListener {
            findNavController(this).navigate(R.id.action_loginFragment_to_registerFragment2)
        }
        binding.loginAction.setOnClickListener {
           startActivity(Intent(activity as LoginRegisterActivity , MainActivity::class.java) )
        }

    }
}