package cn.ljpc.workmanager.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import cn.ljpc.workmanager.util.NetworkUtil


/**
 * 协程 worker
 */
class CoroutineDownloadWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        NetworkUtil.get("https://www.baidu.com")
        return Result.success()
    }
}


//fun main(args: Array<String>) {
//
//    val time = measureTimeMillis {
//        val one = async { doSomethingUsefulOne() }
//        val two = async { doSomethingUsefulTwo() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("总共用时：${time}")
//}
//
////组合挂起函数
//suspend fun doSomethingUsefulOne(): Int {
//    delay(1000L) // 假设我们在这里做了一些有用的事
//    return 13
//}
//
//suspend fun doSomethingUsefulTwo(): Int {
//    delay(1000L) // 假设我们在这里也做了一些有用的事
//    return 29
//}
