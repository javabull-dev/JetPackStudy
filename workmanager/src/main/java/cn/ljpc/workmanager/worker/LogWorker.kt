package cn.ljpc.workmanager.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import cn.ljpc.workmanager.util.NetworkUtil

/**
 * 任务
 */
class LogWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        NetworkUtil.get("https://www.baidu.com")
        return Result.success()
    }
}