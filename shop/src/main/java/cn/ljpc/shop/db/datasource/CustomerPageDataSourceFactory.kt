package cn.ljpc.shop.db.datasource

import androidx.paging.DataSource
import cn.ljpc.shop.db.GoodsRepository
import cn.ljpc.shop.db.data.Goods

/**
 * 创建CustomerPageDataSource的工厂
 */
class CustomerPageDataSourceFactory(private val goodsRepository: GoodsRepository) :
    DataSource.Factory<Int, Goods>() {

    override fun create(): DataSource<Int, Goods> {
        return CustomerPageDataSource(goodsRepository)
    }
}