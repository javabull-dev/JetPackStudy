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
    @Query("select * from user where user_name = :name and user_password = :pwd")
    fun login(name: String, pwd: String): LiveData<User?>

    @Query("select count(1) from user where user_name=:name or user_email=:email")
    fun exist(email: String, name: String): LiveData<Int>

    @Query("SELECT * FROM user WHERE id=:id")
    fun findUserById(id: Long): LiveData<User>

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    //不能使用livedata
    // suspend
    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User)

    @Query("select * from user where id between :startIndex and :endIndex order by id asc ")
    fun findUsersByIndexRange(startIndex: Long, endIndex: Long): List<User>
}