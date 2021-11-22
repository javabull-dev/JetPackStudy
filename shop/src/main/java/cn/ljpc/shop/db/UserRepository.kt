package cn.ljpc.shop.db

import androidx.lifecycle.LiveData
import cn.ljpc.shop.db.dao.UserDao
import cn.ljpc.shop.db.data.User

class UserRepository private constructor(private val userDao: UserDao) {

    /**
     * 用户登录
     */
    fun login(account: String, pwd: String) = userDao.login(account, pwd)

    /**
     * 用户注册
     */
    fun register(email: String, account: String, pwd: String) =
        userDao.insertUser(User(account, pwd, email))

    /**
     * 获取所有的用户
     */
    fun getAllUsers() = userDao.getAllUsers()

    /**
     * 根据id选择用户
     */
    fun findUserById(id: Long): LiveData<User> = userDao.findUserById(id)

//    companion object {
//
//        private var instance: UserRepository? = null
//
//        fun getInstance(userDao: UserDao): UserRepository =
//            instance ?: synchronized(this) {
//                instance ?: UserRepository(userDao).also {
//                    instance = it
//                }
//            }
//    }
}