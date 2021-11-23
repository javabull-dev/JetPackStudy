package cn.ljpc.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import cn.ljpc.shop.db.datasource.CustomerPageDataSource
import cn.ljpc.shop.db.repository.GoodsRepository
import javax.inject.Inject

class GoodsViewModel @Inject constructor(private val goodsRepository: GoodsRepository) :
    ViewModel() {

    /**
     * 创建goods观察数据
     */
    val goods = Pager(
        config = PagingConfig(
            pageSize = 10,//每页的大小
            enablePlaceholders = false,
            initialLoadSize = 10
        ), pagingSourceFactory = {
            CustomerPageDataSource(goodsRepository)
        }).flow
}