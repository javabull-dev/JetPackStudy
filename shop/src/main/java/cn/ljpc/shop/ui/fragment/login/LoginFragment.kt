package cn.ljpc.shop.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentLoginBinding
import cn.ljpc.shop.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        //设置参数
        binding.activity = activity
        binding.model = LoginViewModel("", "", requireContext())
        //返回view
        return binding.root
    }
}