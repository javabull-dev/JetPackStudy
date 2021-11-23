package cn.ljpc.shop.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentMainBinding
import cn.ljpc.shop.ui.adapter.GoodsAdapter
import cn.ljpc.shop.viewmodel.GoodsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var viewModel: GoodsViewModel

    private lateinit var goodsAdapter: GoodsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        goodsAdapter = GoodsAdapter(requireContext())
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.apply {
            recycle.adapter = goodsAdapter
        }
        onUISubscribe()
        return binding.root
    }

    private fun onUISubscribe() {
        viewModel.viewModelScope.launch(Dispatchers.IO) {
            viewModel.goods.collect {
                goodsAdapter.submitData(it)
            }
        }
    }
}