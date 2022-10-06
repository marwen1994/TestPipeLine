package com.example.testpipeline.feature.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.testpipeline.R
import com.example.testpipeline.databinding.FragmentFavoriteFoodBinding
import com.example.testpipeline.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handledNavigation()
    }
    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
    private fun handledNavigation(){
        binding.navigateToLogin.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}