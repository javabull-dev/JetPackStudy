package cn.ljpc.shop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import cn.ljpc.shop.db.dao.GoodsDao
import cn.ljpc.shop.db.dao.UserDao
import cn.ljpc.shop.db.data.Goods
import cn.ljpc.shop.db.data.User

/**
 * 数据库文件
 */
@Database(entities = [User::class, Goods::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    /**
     * 获取UserDao
     */
    abstract fun userDao(): UserDao

    /**
     * 获取GoodsDao
     */
    abstract fun goodsDao(): GoodsDao
}