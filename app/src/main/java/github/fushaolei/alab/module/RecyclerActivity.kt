package github.fushaolei.alab.module

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_recyclerview.*

class RecyclerActivity : ABaseActivity() {
    private lateinit var dataList: ArrayList<Msg>
    private lateinit var mAdapter: MyAdapter

    override fun initView() {
        dataList = ArrayList()
        dataList.add(Msg(R.drawable.ic_launcher_background, "任我行", "天涯孤影任我行"))
        dataList.add(Msg(R.drawable.ic_launcher_foreground, "令狐冲", "天涯孤影任我行"))
        dataList.add(Msg(R.drawable.ic_launcher_background, "曲非烟", "天涯孤影任我行"))
        dataList.add(Msg(R.drawable.ic_launcher_foreground, "苏星河", "天涯孤影任我行"))
        dataList.add(Msg(R.drawable.ic_launcher_background, "任盈盈", "天涯孤影任我行"))

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


}