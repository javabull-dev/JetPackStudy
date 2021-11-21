package cn.ljpc.shop.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.databinding.ObservableField
import cn.ljpc.shop.MainActivity
import cn.ljpc.shop.data.Constants

class LoginViewModel(name: String, pwd: String, context: Context) {

    val _name = ObservableField(name)
    val _pwd = ObservableField(pwd)
    var _context = context

    /**
     * 用户名发生改变时回调
     */
    fun onNameChange(s: CharSequence) {
        _name.set(s.toString())
    }

    /**
     * 密码发生改变时回调
     */
    fun onPwdChange(s: CharSequence, start: Int, before: Int, count: Int) {
        _pwd.set(s.toString())
    }

    /**
     * 登录，用户名和密码，验证
     */
    fun login() {
        if (_name.get().equals(Constants.USER_NAME) && _pwd.get().equals(Constants.PASSWORD)) {
            Toast.makeText(_context, "登录成功", Toast.LENGTH_SHORT).show();
            _context.startActivity(Intent(_context, MainActivity::class.java))
        } else {
            Toast.makeText(_context, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}