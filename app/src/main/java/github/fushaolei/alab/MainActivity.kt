package github.fushaolei.alab

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.fushaolei.alab.module.*
import github.fushaolei.lib.base.ABaseActivity
import github.fushaolei.lib.base.ARecyclerAdapter
import github.fushaolei.lib.base.ARecyclerViewHolder
import github.fushaolei.lib.utils.ALog
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : ABaseActivity() {
    private val mContainer = arrayListOf<Item<*>>(
        Item("ARecyclerAdapter测试", RecyclerViewTest::class.java),
        Item("ACache测试", CacheTest::class.java),
        Item("Retrofit协程测试", RetrofitTest::class.java),
        Item("Permission测试", PermissionTest::class.java),
        Item("ImageSelector测试", ImagePickerTest::class.java),
        Item("Http测试", HttpTest::class.java)
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