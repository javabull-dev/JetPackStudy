package cn.ljpc.hiltdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object Module3 {

    @OneRetrofit
    @Provides
    fun provide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/") //设置网络请求的Url地址
            .build()
    }

    @Provides
    @TwoRetrofit
    fun provide2(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/") //设置网络请求的Url地址
            .build()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OneRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TwoRetrofit