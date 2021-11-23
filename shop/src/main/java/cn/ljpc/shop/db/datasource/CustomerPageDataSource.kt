package cn.ljpc.shop.db.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import cn.ljpc.shop.db.data.Goods
import cn.ljpc.shop.db.repository.GoodsRepository

class CustomerPageDataSource constructor(private val goodsRepository: GoodsRepository) :
    PagingSource<Int, Goods>() {

    companion object {
        val TAG = CustomerPageDataSource::class.qualifiedName
    }

    /**
     * PagingSource 实现必须定义如何从已加载分页数据的中间恢复刷新
     */
    override fun getRefreshKey(state: PagingState<Int, Goods>): Int? {
        Log.d(TAG, "更新key, state.anchorPosition=${state.anchorPosition}")
        return state.anchorPosition
    }

    /**
     * 加载数据
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Goods> {
        Log.d(TAG, "load, 从数据库中加载数据, key=${params.key}, 一页数量=${params.loadSize}")
        val index = params.key ?: 0
        return try {
            val goodies =
                goodsRepository.getGoodsPage(index * params.loadSize, params.loadSize)
            LoadResult.Page(
                goodies,
                if (index < 0) null else index - 1,
                if (goodies.isNullOrEmpty()) null else index + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}