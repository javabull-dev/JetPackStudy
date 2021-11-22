package cn.ljpc.hiltdemo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Module 抽象类
 * bindDog 抽象方法
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class Module {

    @Binds
    abstract fun bindDog(dog: Dog): Animal
}