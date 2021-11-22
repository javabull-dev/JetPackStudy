package cn.ljpc.shop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import cn.ljpc.shop.db.dao.UserDao
import cn.ljpc.shop.db.data.User

/**
 * 数据库文件
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    /**
     * 获取UserDao
     */
    abstract fun userDao(): UserDao

    /**
     * 不需要写了
     */
//    companion object {
//
//        private var instance: AppDataBase? = null
//
//        fun getInstance(context: Context): AppDataBase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDataBase(context).also {
//                    instance = it
//                }
//            }
//        }
//
//        //创建数据库
//        private fun buildDataBase(context: Context): AppDataBase {
//            return Room
//                .databaseBuilder(context, AppDataBase::class.java, "jetpack-shop")
//                .addCallback(object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        //可以做一些其他的事情
//                    }
//                })
//                .build()
//        }
//    }
}