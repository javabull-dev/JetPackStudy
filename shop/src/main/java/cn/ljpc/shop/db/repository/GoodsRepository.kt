package cn.ljpc.shop.db.repository

import cn.ljpc.shop.db.dao.GoodsDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoodsRepository @Inject constructor(private val goodsDao: GoodsDao) {

    /**
     * 分页查询
     */
    fun getGoodsPage(startIndex: Int, count: Int) = goodsDao.getGoodsPage(startIndex, count)

    /**
     * 通过id获取商品信息
     */
    fun getGoods(index: Int) = goodsDao.getGoodsById(index)
}