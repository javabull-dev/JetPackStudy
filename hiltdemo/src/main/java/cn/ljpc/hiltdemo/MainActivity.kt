package cn.ljpc.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.ljpc.hiltdemo.entity.User
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var dog: Dog

    @Inject
    lateinit var retrofit: Retrofit

    @OneRetrofit
    @Inject
    lateinit var retrofit2: Retrofit

    @TwoRetrofit
    @Inject
    lateinit var retrofit3: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "user: ${user._age}-${user._name}")
        dog.shout("我是一条狗，我在叫")
        Log.d(TAG, retrofit.toString())
        Log.d(TAG, retrofit2.toString())
        Log.d(TAG, retrofit3.toString())
    }

    companion object {
        val TAG = MainActivity::class.qualifiedName
    }
}