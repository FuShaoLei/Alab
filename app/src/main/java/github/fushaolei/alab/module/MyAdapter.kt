package github.fushaolei.alab.module

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.base.ARecyclerViewHolder

class MyAdapter(dataList: MutableList<Msg>) : ARecyclerAdapter<Msg, MyAdapter.ViewHolder>(dataList) {


    override fun getItemLayout(): Int = R.layout.item_recyclerview

    override fun convert(holder: ViewHolder, item: Msg) {
        holder.avator.setImageResource(item.avator)
        holder.name.text = item.name
        holder.message.text = item.message
    }

    override fun onReturnVH(view: View): ViewHolder {
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View) : ARecyclerViewHolder(itemView) {
        var avator: ImageView = itemView.findViewById(R.id.iv_avator)
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var message: TextView = itemView.findViewById(R.id.tv_msg)
    }
}