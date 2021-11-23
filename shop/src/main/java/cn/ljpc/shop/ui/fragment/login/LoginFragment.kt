package cn.ljpc.shop.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentLoginBinding
import cn.ljpc.shop.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var loginViewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        this.binding = binding
        //设置参数
        binding.activity = activity
        binding.model = loginViewModel
        binding.isEnable = false
        //为loginviewmodel设置lifecycle
        loginViewModel.lifecycleOwner = viewLifecycleOwner
        //返回view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel._pwd.observe(viewLifecycleOwner, Observer {
            binding.isEnable = !(it.isEmpty() && loginViewModel._name.value!!.isEmpty())
        })
    }
}
