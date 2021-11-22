package cn.ljpc.shop.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cn.ljpc.shop.db.data.User

@Dao
interface UserDao {

    // :pwd 参数取值
    @Query("select * from user where user_account = :account and user_password = :pwd")
    fun login(account: String, pwd: String): LiveData<User?>

    @Query("SELECT * FROM user WHERE id=:id")
    fun findUserById(id: Long): LiveData<User>

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User)
}