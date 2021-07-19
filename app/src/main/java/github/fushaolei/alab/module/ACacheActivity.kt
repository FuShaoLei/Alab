package github.fushaolei.alab.module

import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.utils.ACache
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_cache.*

class ACacheActivity : ABaseActivity() {
    private val TAG = "key"
    override fun initView() {
        btn_save.setOnClickListener {
            var text = et_text.text.toString()
            if (text.isNotEmpty()) {
                ACache.save(TAG, text)
            }
        }
        btn_show.setOnClickListener {
            AToast.show("${ACache.get(TAG)}")
        }

    }

    override fun getLayoutId(): Int {
        return R.layout.act_cache
    }
}