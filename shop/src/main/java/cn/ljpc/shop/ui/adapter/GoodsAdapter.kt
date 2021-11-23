package cn.ljpc.shop.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.ljpc.shop.databinding.RecycleItemGoodsBinding
import cn.ljpc.shop.db.data.Goods

/**
 * GoodsAdapter 配合databinding使用
 */
class GoodsAdapter constructor(val context: Context) :
    PagingDataAdapter<Goods, GoodsAdapter.ViewHolder>(GoodsDiffCallback()) {

    class ViewHolder(private val binding: RecycleItemGoodsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Goods) {
            binding.apply {
                this.listener = listener
                this.goods = item
                executePendingBindings()
            }
        }
    }

    /**
     * 创建view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecycleItemGoodsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    /**
     * 绑定数据
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goods = getItem(position)
        holder.apply {
            bind(onCreateListener(goods!!.id), goods)
        }
    }

    /**
     * 创建点击监听器
     */
    private fun onCreateListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra(BaseConstant.DETAIL_SHOE_ID, id)
//            context.startActivity(intent)
            //todo 跳转到详情页
        }
    }
}