package cn.ljpc.navigation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import cn.ljpc.navigation.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.findViewById<Button>(R.id.btn_home)?.setOnClickListener {
            //传参
            var args = HomeFragmentArgs.Builder().also {
                it.age = 20
                it.userName = "jacker"
            }.build().toBundle()
            //实现跳转
            view.findNavController().navigate(R.id.action_homeFragment2_to_detailFragment, args)
        }
    }
}