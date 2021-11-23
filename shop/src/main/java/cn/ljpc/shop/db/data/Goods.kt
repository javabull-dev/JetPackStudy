package cn.ljpc.shop.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 商品表
 */
@Entity(tableName = "goods")
data class Goods(
    @ColumnInfo(name = "goods_name") val name: String,
    @ColumnInfo(name = "goods_desc") val description: String,
    @ColumnInfo(name = "goods_price") val price: Float,
    @ColumnInfo(name = "goods_image_url") val imageUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}