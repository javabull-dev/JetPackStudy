package cn.ljpc.shop.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import cn.ljpc.shop.db.data.Goods

class GoodsDiffCallback : DiffUtil.ItemCallback<Goods>() {

    override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem == newItem
    }
}