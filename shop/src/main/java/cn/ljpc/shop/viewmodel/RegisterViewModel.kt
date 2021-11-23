package cn.ljpc.shop.viewmodel

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.lifecycle.*
import cn.ljpc.shop.ui.activity.MainActivity
import cn.ljpc.shop.db.UserRepository
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterViewModel @Inject constructor(@ActivityContext private var context: Context) :
    ViewModel() {

    val _name = MutableLiveData("")
    val _pwd = MutableLiveData("")
    val _email = MutableLiveData("")

    lateinit var lifecycleOwner: LifecycleOwner

    //注入的字段不能是private
    @Inject
    lateinit var userRepository: UserRepository

    /**
     * 注册相关的逻辑
     */
    fun register() {
        val name = _name.value!!
        val pwd = _pwd.value!!
        val email = _email.value!!
        if (name.isEmpty() || pwd.isEmpty() || email.isEmpty()) {
            Toast.makeText(context, "所有信息均为必填项", Toast.LENGTH_SHORT).show()
        } else {
            userRepository.exist(email, name).observe(lifecycleOwner, Observer {
                if (it > 0) {
                    Toast.makeText(context, "用户已存在", Toast.LENGTH_SHORT).show()
                } else {
                    //创建协程，执行任务
                    viewModelScope.launch(Dispatchers.IO) {
                        val count = userRepository.register(email, name, pwd)
                        //线程切换
                        withContext(Dispatchers.Main) {
                            showResult(count > 0)
                        }
                    }
                }
            })
        }
    }

    //需要在Ui线程上执行的函数
    @MainThread
    fun showResult(flag: Boolean) {
        if (flag) {
            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show()
            MainActivity.toMainActivity(context)
        } else {
            Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show()
        }
    }
}