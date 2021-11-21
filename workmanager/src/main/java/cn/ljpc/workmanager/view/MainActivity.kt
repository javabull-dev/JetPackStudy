package cn.ljpc.workmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import cn.ljpc.workmanager.R
import cn.ljpc.workmanager.worker.LogWorker
import java.util.concurrent.TimeUnit

/**
 * WorkManager：可靠的异步任务
 * 轻松调度那些即使在退出应用或重启设备后仍应运行的可靠异步任务。
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWork()

    }

    private fun startWork() {
//        var workQuest = OneTimeWorkRequest.from(LogWorker::class.java)
        //一次性异步任务任务
        val logWorkRequestBuilder: WorkRequest = OneTimeWorkRequestBuilder<LogWorker>().build()
        WorkManager.getInstance(this).enqueue(logWorkRequestBuilder)
    }

    //定期任务
    private fun startPeriodWork() {
        //添加约束
        //只在有网络并且充电的情况下
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .build()

        //再每小时的最后15分钟开始执行
        var requestWorker = PeriodicWorkRequestBuilder<LogWorker>(
            1, TimeUnit.HOURS,
            15, TimeUnit.MINUTES
        ).setConstraints(constraints).build()

        WorkManager.getInstance(this).enqueue(requestWorker)
    }
}