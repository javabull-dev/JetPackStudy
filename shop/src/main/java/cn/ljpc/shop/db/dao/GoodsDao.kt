package cn.ljpc.shop.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import cn.ljpc.shop.db.data.Goods

@Dao
interface GoodsDao {

    /**
     * 通过id查询商品信息
     */
    @Query("select * from goods where id=:id")
    fun getGoodsById(id: Int): LiveData<Goods?>

    /**
     * 分页查询商品信息
     */
    @Query("select * from goods limit :startIndex, :count")
    fun getGoodsPage(startIndex: Int, count: Int): List<Goods>
}