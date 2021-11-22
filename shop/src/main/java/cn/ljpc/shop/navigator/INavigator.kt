package cn.ljpc.shop.navigator

/**
 * 屏幕，枚举值
 */
enum class Screens {
    MAIN_SCREEN, MARK_SCREEN, ME_SCREEN
}

/**
 * 导航
 */
interface INavigator {
    /**
     * 导航到某个fragment
     */
    fun navigateTo(screens: Screens)
}