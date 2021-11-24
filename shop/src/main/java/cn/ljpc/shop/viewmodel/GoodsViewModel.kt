package cn.ljpc.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cn.ljpc.shop.db.data.Goods
import cn.ljpc.shop.db.datasource.CustomerPageDataSource
import cn.ljpc.shop.db.repository.GoodsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoodsViewModel @Inject constructor(private val goodsRepository: GoodsRepository) :
    ViewModel() {

    /**
     * 创建一个flow对象
     */
    val goods: Flow<PagingData<Goods>> = Pager(
        config = PagingConfig(
            pageSize = 10,//每页的大小
            enablePlaceholders = false,
            initialLoadSize = 10
        ), pagingSourceFactory = {
            CustomerPageDataSource(goodsRepository)
        }).flow
}