package cn.ljpc.hiltdemo

import android.util.Log
import cn.ljpc.hiltdemo.Animal.Companion.TAG
import javax.inject.Inject

/**
 * 接口注入的方式
 */
interface Animal {
    fun shout(name: String)

    companion object {
        val TAG = Animal::class.qualifiedName
    }
}

/**
 * 实现类1
 */
class Dog @Inject constructor() : Animal {
    override fun shout(name: String) {
        Log.d(TAG, "$name shout")
    }
}

/**
 * 实现类2
 */
class Cat @Inject constructor() : Animal {
    override fun shout(name: String) {
        Log.d(TAG, "$name shout")
    }
}