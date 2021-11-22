package cn.ljpc.shop

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp 会触发 Hilt 的代码生成操作，生成的代码包括应用的一个基类，该基类充当应用级依赖项容器。
@HiltAndroidApp
class ShopApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Iimber 日志配置
    }
}