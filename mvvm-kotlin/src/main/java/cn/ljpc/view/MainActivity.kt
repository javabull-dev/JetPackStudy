package cn.ljpc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import cn.ljpc.R
import cn.ljpc.model.Animal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animal = Animal("dog", 0)

        //初始化
        findViewById<TextView>(R.id.info_tv).text = "${animal.name} 叫了 ${animal.shoutCount}声.."

        //绑定事件
        findViewById<View>(R.id.action_btn).setOnClickListener {
            animal.shoutCount++
            findViewById<TextView>(R.id.info_tv).text = "${animal.name} 叫了 ${animal.shoutCount}声.."
        }
    }
}