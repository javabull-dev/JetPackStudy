package cn.ljpc.shop.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//声明实体
@Entity(tableName = "user")
data class User(
    //声明字段
    @ColumnInfo(name = "user_name") val name: String,//用户的名称
    @ColumnInfo(name = "user_email") val account: String, //用户的邮箱
    @ColumnInfo(name = "user_password") val pwd: String//用户的密码
) {
    //声明主键
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}