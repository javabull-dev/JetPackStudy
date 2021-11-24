package cn.ljpc.shop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.ljpc.shop.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * 登录的Activity
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}