package cn.ljpc.navigation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import cn.ljpc.navigation.R

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        requireArguments()，函数内部非空判断，为空则抛出异常
        if (arguments != null) {
//            var args = HomeFragmentArgs.fromBundle(arguments)
//            Log.d("lan", "名字:${args.userName} 年龄：${args.age}")
        }
        getView()?.findViewById<Button>(R.id.btn_detail)?.setOnClickListener {
            view.findNavController().navigate(R.id.action_detailFragment_to_homeFragment2)
        }
    }
}