package cn.ljpc.shop.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import cn.ljpc.shop.db.AppDataBase
import cn.ljpc.shop.db.dao.GoodsDao
import cn.ljpc.shop.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton//单例
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room
            .databaseBuilder(context, AppDataBase::class.java, "jetpack-shop.db")
            .createFromAsset("database/jetpack-shop.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    //可以做一些其他的事情
                }
            })
            .build()

    }

    @Provides
    fun provideUserDao(dataBase: AppDataBase): UserDao {
        return dataBase.userDao()
    }

    @Provides
    fun provideGoodsDao(dataBase: AppDataBase): GoodsDao {
        return dataBase.goodsDao()
    }
}