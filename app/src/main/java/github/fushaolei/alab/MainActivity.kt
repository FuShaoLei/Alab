package github.fushaolei.alab

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.fushaolei.alab.module.ACacheActivity
import github.fushaolei.alab.module.APermissionActivity
import github.fushaolei.alab.module.ARecyclerActivity
import github.fushaolei.alab.module.ARetrofitActivity
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.base.ARecyclerViewHolder
import github.fushaolei.lib.test.utils.ALog
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : ABaseActivity() {
    private val mContainer = arrayListOf<Item<*>>(
        Item("ARecyclerAdapter测试", ARecyclerActivity::class.java),
        Item("ACache测试", ACacheActivity::class.java),
        Item("Retrofit协程测试", ARetrofitActivity::class.java),
        Item("Permission测试", APermissionActivity::class.java)
    )

    override fun initView() {
        var adapter = MainAdapter(mContainer)
        var lm = LinearLayoutManager(baseContext)
        lm.orientation = RecyclerView.VERTICAL
        rv_main.layoutManager = lm
        rv_main.adapter = adapter

        adapter.setOnItemClickListener(object : ARecyclerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                startActivity(Intent(this@MainActivity, mContainer[position].clazz))
                ALog.show("点击了 ${mContainer[position].clazz.simpleName}")
            }

        })

    }

    override fun getLayoutId(): Int = R.layout.act_main


    data class Item<T : Activity>(val text: String, val clazz: Class<T>)

    class MainAdapter(dataList: MutableList<Item<*>>) :
        ARecyclerAdapter<Item<*>, MainAdapter.ViewHolder>(
            dataList) {
        class ViewHolder(itemView: View) : ARecyclerViewHolder(itemView) {
            var btn: Button = itemView.findViewById(R.id.btn_text)
        }

        override fun onReturnVH(view: View): ViewHolder {
            return ViewHolder(view)
        }

        override fun getItemLayout(): Int {
            return R.layout.item_main
        }

        override fun convert(holder: ViewHolder, item: Item<*>) {
            holder.btn.text = item.text
        }

    }
}