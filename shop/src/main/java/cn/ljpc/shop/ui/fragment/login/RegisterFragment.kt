package cn.ljpc.shop.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentRegisterBinding
import cn.ljpc.shop.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //使用databinding
        val binding: FragmentRegisterBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.activity = activity
        binding.model = RegisterViewModel("", "", "", requireContext())
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}