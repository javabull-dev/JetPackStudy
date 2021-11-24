package cn.ljpc.timeber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import cn.ljpc.timeber.ui.login.LoginActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Timber.d("onCreateOptionsMenu  menu被创建了")
        menuInflater.inflate(R.menu.menu_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Timber.d("onOptionsItemSelected  menu被点击了")
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart 被调用")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Timber.d("onBackPressed 被调用")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("onRestart 被调用")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume 被调用")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop 被调用")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy 被调用")
    }
}