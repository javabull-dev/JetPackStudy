package cn.ljpc.shop.di

import cn.ljpc.shop.navigator.INavigator
import cn.ljpc.shop.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl: NavigatorImpl): INavigator
}