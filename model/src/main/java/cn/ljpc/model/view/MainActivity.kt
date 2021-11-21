package cn.ljpc.model.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cn.ljpc.model.R
import cn.ljpc.model.viewmodel.ItemViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: ItemViewModel by viewModels()
        model.item.observe(this) {
            findViewById<TextView>(R.id.tx_show).text = "当前${it}次"
        }

        //对象表达式
        Timer().schedule(object : TimerTask() {
            override fun run() {
                model.item.postValue(model.item.value!! + 1)
                Log.d("lan", "model的值${model.item.value}")
            }
        }, 0, 1000)

    }
}