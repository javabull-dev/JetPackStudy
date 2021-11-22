package cn.ljpc.shop.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//声明实体
@Entity(tableName = "user")
data class User(
    //声明字段
    @ColumnInfo(name = "user_account") val account: String,
    @ColumnInfo(name = "user_password") val pwd: String,
    @ColumnInfo(name = "user_name") val name: String
) {
    //声明主键
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}