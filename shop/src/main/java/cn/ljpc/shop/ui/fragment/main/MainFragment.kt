package cn.ljpc.shop.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.ljpc.shop.R
import cn.ljpc.shop.databinding.FragmentMainBinding
import cn.ljpc.shop.ui.adapter.GoodsAdapter
import cn.ljpc.shop.viewmodel.GoodsViewModel
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 主页面，利用RecycleView显示商品
 */
@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var viewModel: GoodsViewModel

    private lateinit var goodsAdapter: GoodsAdapter

    private var currentStates: LoadStates? = null

    private lateinit var binding: FragmentMainBinding

    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        goodsAdapter = GoodsAdapter(requireContext())
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.apply {
            recycleView.adapter = goodsAdapter
        }
        onUISubscribe()
        return binding.root
    }

    /**
     * 订阅可观察数据，更新UI
     */
    private fun onUISubscribe() {

        goodsAdapter.addLoadStateListener {
            currentStates = it.source

            // 如果append没有处于加载状态，但是refreshLayout出于加载状态，refreshLayout停止加载状态
            if (it.append is LoadState.NotLoading && binding.refreshLayout.isLoading) {
                refreshLayout.finishLoadMore()
            }

            // 如果refresh没有出于加载状态，但是refreshLayout出于刷新状态，refreshLayout停止刷新
            if (it.source.refresh is LoadState.NotLoading && binding.refreshLayout.isRefreshing) {
                refreshLayout.finishRefresh()
            }
        }

        binding.recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastPos = getLastVisiblePosition(binding.recycleView)
                if (!(lastPos == goodsAdapter.itemCount - 1 && currentStates?.append is LoadState.Loading)) {
                    binding.refreshLayout.finishLoadMore()
                }
            }
        })

        job = viewModel.viewModelScope.launch(Dispatchers.IO) {
            //collect消费
            viewModel.goods.collect {
                goodsAdapter.submitData(it)
            }
        }

        binding.refreshLayout.setRefreshHeader(ClassicsHeader(context))
        binding.refreshLayout.setRefreshFooter(ClassicsFooter(context))
        binding.refreshLayout.setOnLoadMoreListener {
            // 如果当前数据已经全部加载完，就不再加载
            if (currentStates?.append?.endOfPaginationReached == true)
                binding.refreshLayout.finishLoadMoreWithNoMoreData()
        }
    }

    fun getLastVisiblePosition(recyclerView: RecyclerView): Int {
        val layoutManager: RecyclerView.LayoutManager? = recyclerView.layoutManager
        return if (layoutManager is LinearLayoutManager) {
            layoutManager.findLastVisibleItemPosition()
        } else -1
    }
}