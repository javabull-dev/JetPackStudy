package cn.ljpc.shop.navigator

import androidx.fragment.app.FragmentActivity
import cn.ljpc.shop.R
import cn.ljpc.shop.ui.fragment.main.MainFragment
import cn.ljpc.shop.ui.fragment.main.MarkFragment
import cn.ljpc.shop.ui.fragment.main.MeFragment
import javax.inject.Inject

class NavigatorImpl @Inject constructor(private val activity: FragmentActivity) : INavigator {

    override fun navigateTo(screens: Screens) {
        val fragment = when (screens) {
            Screens.MAIN_SCREEN -> MainFragment::class.java
            Screens.MARK_SCREEN -> MarkFragment::class.java
            Screens.ME_SCREEN -> MeFragment::class.java
        }

        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragment, fragment, null) //替换
            .addToBackStack(fragment::class.java.canonicalName)//显示
            .commit()
    }
}