package cn.ljpc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.ljpc.R
import cn.ljpc.databinding.ActivityMainBinding
import cn.ljpc.model.Animal
import cn.ljpc.viewmodel.AnimalViewModel

class MainActivity2 : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    lateinit var mViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = AnimalViewModel(Animal("哈巴狗", 0))
        mBinding.vm = mViewModel
        //LiveData
        mBinding.lifecycleOwner = this
    }
}