package cn.ljpc.shop.db

import androidx.lifecycle.LiveData
import cn.ljpc.shop.db.dao.UserDao
import cn.ljpc.shop.db.data.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val userDao: UserDao) {

    /**
     * 用户登录
     */
    fun login(name: String, pwd: String) = userDao.login(name, pwd)

    /**
     * 用户注册
     */
    fun register(email: String, name: String, pwd: String) =
        userDao.insertUser(User(name, email, pwd))

    /**
     * 用户信息是否已经存在
     */
    fun exist(email: String, name: String) = userDao.exist(email, name)

    /**
     * 获取所有的用户
     */
    fun getAllUsers() = userDao.getAllUsers()

    /**
     * 根据id选择用户
     */
    fun findUserById(id: Long): LiveData<User> = userDao.findUserById(id)

    /**
     * 分页查询
     */
    fun getPagesUser(startIndex: Long, endIndex: Long): List<User> =
        userDao.findUsersByIndexRange(startIndex, endIndex)
}