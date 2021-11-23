package cn.ljpc.shop.db.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import cn.ljpc.shop.db.GoodsRepository
import cn.ljpc.shop.db.data.Goods

class CustomerPageDataSource constructor(private val goodsRepository: GoodsRepository) :
    PageKeyedDataSource<Int, Goods>() {

    /**
     * 每次分页加载的时候调用
     */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Goods>) {
        Log.d(TAG, "loadAfter --- 起始页：${params.key}，加载数量：${params.requestedLoadSize}")
        val goodes =
            goodsRepository.getGoodsPage(
                params.key * params.requestedLoadSize,
                params.requestedLoadSize
            )
        callback.onResult(goodes, params.key + 1)
        Log.d(TAG, "从数据库中查询出的商品信息数据：${goodes}")
    }

    /**
     * 每次分页加载的时候调用
     * 加载之前的数据
     */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Goods>) {
        Log.d(TAG, "loadBefore --- 起始页：${params.key}，加载数量：${params.requestedLoadSize}")
        val goodes =
            goodsRepository.getGoodsPage(
                params.key * params.requestedLoadSize,
                params.requestedLoadSize
            )
        callback.onResult(goodes, params.key + 1)
    }

    /**
     * 第一加载的时候调用
     */
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Goods>
    ) {
        val goodes = goodsRepository.getGoodsPage(0, params.requestedLoadSize)
        callback.onResult(goodes, null, 1)
        Log.d(TAG, "loadInitial -- 从数据库中查询出的goods数据：${goodes}")
    }

    companion object {
        val TAG = CustomerPageDataSource::class.qualifiedName
    }
}