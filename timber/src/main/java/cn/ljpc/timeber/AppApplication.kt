package cn.ljpc.timeber

import android.app.Application
import timber.log.Timber

/**
 * 自定义的Applicaiton
 */
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}

/**
 * 自定义的Tree
 */
class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        println("priority=${priority}, tag=${tag}, message=${message}, throwable=${t}}")
    }
}