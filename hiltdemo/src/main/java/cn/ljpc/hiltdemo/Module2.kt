package cn.ljpc.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object Module2 {

    /**
     *  无法通过构造函数注入
     *  使用Provides
     */
    @Provides
    fun provide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/") //设置网络请求的Url地址
            .build()
    }
}