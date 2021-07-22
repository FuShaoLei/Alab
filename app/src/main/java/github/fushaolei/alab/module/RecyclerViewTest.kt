package github.fushaolei.alab.module

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.base.ARecyclerViewHolder
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_recyclerview.*

class RecyclerViewTest : ABaseActivity() {
    private val dataList = arrayListOf<Msg>(
        Msg(R.drawable.ic_launcher_background, "任我行", "天涯孤影任我行"),
        Msg(R.drawable.ic_launcher_foreground, "令狐冲", "天涯孤影任我行"),
        Msg(R.drawable.ic_launcher_background, "曲非烟", "天涯孤影任我行"),
        Msg(R.drawable.ic_launcher_foreground, "苏星河", "天涯孤影任我行"),
        Msg(R.drawable.ic_launcher_background, "任盈盈", "天涯孤影任我行")
    )
    private lateinit var mAdapter: MyAdapter

    override fun initView() {

        mAdapter = MyAdapter(dataList)
        var lm = LinearLayoutManager(baseContext)
        lm.orientation = RecyclerView.VERTICAL

        rv.layoutManager = lm
        rv.adapter = mAdapter

        mAdapter.setOnItemClickListener(object : ARecyclerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                AToast.show("position = $position")
            }
        })
    }

    override fun getLayoutId(): Int = R.layout.act_recyclerview


    data class Msg(var avator: Int, var name: String, var message: String)

    class MyAdapter(dataList: MutableList<Msg>) :
        ARecyclerAdapter<Msg, MyAdapter.ViewHolder>(dataList) {


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
}