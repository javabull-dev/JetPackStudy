package cn.ljpc.shop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var firstPressdTime: Long = -2000
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /**
     * 初始化view
     */
    private fun initView() {
        bottomNavigationView = findViewById(R.id.bottom_nav_view)
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment
        val navController = host.navController
        bottomNavigationView.getOrCreateBadge(R.id.infoFragmentItem)

        bottomNavigationView.setupWithNavController(navController)
    }

    /**
     *连续按两次回退键 退出app
     */
    override fun onBackPressed() {
        //todo 关闭不彻底
        if (System.currentTimeMillis() - firstPressdTime < 2000) { //2s
            //彻底关闭整个APP
            val startMain = Intent(Intent.ACTION_MAIN)
            startMain.addCategory(Intent.CATEGORY_HOME)
            startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(startMain)
            exitProcess(0)
        } else {
            firstPressdTime = System.currentTimeMillis()
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun toMainActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}