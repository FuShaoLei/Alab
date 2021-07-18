package github.fushaolei.alab

import android.content.Intent
import github.fushaolei.alab.module.RecyclerActivity
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.utils.ALog
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : ABaseActivity() {
    override fun initView() {
        ALog.show("MainActivity initView(￣▽￣)")
        btn_recyclerview.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }

    override fun getLayoutId(): Int = R.layout.act_main

}