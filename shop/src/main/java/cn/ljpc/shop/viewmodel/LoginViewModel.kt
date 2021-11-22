package cn.ljpc.shop.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.ljpc.shop.MainActivity
import cn.ljpc.shop.db.UserRepository
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    @ActivityContext private val context: Context,
    private val repository: UserRepository
) :
    ViewModel() {

    val _name = MutableLiveData("")
    val _pwd = MutableLiveData("")
    lateinit var lifecycleOwner: LifecycleOwner

    /**
     * 用户名发生改变时回调
     */
    fun onNameChange(s: CharSequence) {
        _name.value = s.toString()
    }

    /**
     * 密码发生改变时回调
     */
    fun onPwdChange(s: CharSequence, start: Int, before: Int, count: Int) {
        _pwd.value = s.toString()
    }

    /**
     * 登录，用户名和密码，验证
     */
    fun login() {
        val pwd = _pwd.value!! //非空
        val name = _name.value!!//非空
        repository.login(name, pwd).observe(lifecycleOwner, {
            if (it != null) {
                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                MainActivity.toMainActivity(context)
            } else {
                Toast.makeText(context, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        })
    }
}