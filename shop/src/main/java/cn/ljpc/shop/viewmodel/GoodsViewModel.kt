package cn.ljpc.shop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import cn.ljpc.shop.db.GoodsRepository
import cn.ljpc.shop.db.data.Goods
import cn.ljpc.shop.db.datasource.CustomerPageDataSourceFactory
import javax.inject.Inject

class GoodsViewModel @Inject constructor(private val goodsRepository: GoodsRepository) :
    ViewModel() {

    /**
     * 创建goods观察数据
     */
    val goods: LiveData<PagedList<Goods>> =
        LivePagedListBuilder(
            CustomerPageDataSourceFactory(goodsRepository),//工厂
            PagedList.Config.Builder()
                .setPageSize(10)//设置加载数量
                .setEnablePlaceholders(false)//当item为null，是否使用placeHolder展示
                .setInitialLoadSizeHint(10)//预加载的数量
                .build()
        ).build()
}