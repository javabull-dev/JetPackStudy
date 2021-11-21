package cn.ljpc.shop.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import cn.ljpc.shop.MainActivity

class RegisterViewModel(name: String, pwd: String, email: String, context: Context) {
    val _name = ObservableField(name)
    val _pwd = ObservableField(pwd)
    var _context = context
    val _email = ObservableField(email)

    fun register() {
        if (_name.get()?.isEmpty() == true || _pwd.get()?.isEmpty() == true || _email.get()
                ?.isEmpty() == true
        ) {
            Toast.makeText(_context, "所有信息均为必填项", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(_context, "注册成功", Toast.LENGTH_SHORT).show();
            MainActivity.toMainActivity(context = _context)
        }
    }
}