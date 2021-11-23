package cn.ljpc.shop.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentMainBinding
import cn.ljpc.shop.ui.adapter.GoodsAdapter
import cn.ljpc.shop.viewmodel.GoodsViewModel
import dagger.hilt.android.AndroidEntryPoint
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
        //观察数据
        viewModel.goods.observe(viewLifecycleOwner, {
            if (it != null) {
                //更新页面
                goodsAdapter.submitList(it)
            }
        })
    }
}