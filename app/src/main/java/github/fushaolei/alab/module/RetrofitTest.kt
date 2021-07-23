package github.fushaolei.alab.module

import android.view.View
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.utils.AScope
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.ARetrofit
import github.fushaolei.lib.test.utils.AToast
import github.fushaolei.lib.test.weight.ATitleBar
import kotlinx.android.synthetic.main.act_retrofit.*
import kotlinx.coroutines.*
import retrofit2.http.GET

class RetrofitTest : ABaseActivity() {
    // 随机诗词api:https://v1.jinrishici.com/all.json

    private val myScope = AScope.getScope()
    private val apiService by lazy {
        ARetrofit.getService("https://v1.jinrishici.com", PoemService::class.java)
    }


    override fun initView() {
        btn_update.setOnClickListener {
            // 协程写法
            myScope.launch {
                ALog.show("当前线程名：${Thread.currentThread().name}")
                var getP = apiService!!.getPoemByCoroutines()
                ALog.show(getP.content)
                tv_text.text = getP.content

            }
        }
        title_bars.setOnLeftClickListener(object :ATitleBar.OnLeftClickListener{
            override fun onLeftClick(v: View?) {
                finish()
            }
        })
        title_bars.setOnCenterClickListener(object :ATitleBar.OnCenterClickListener{
            override fun onTitleClick(v: View?) {
                AToast.show("你点击了标题栏！")
            }

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.act_retrofit
    }

    data class Poem(
        var content: String,
        var origin: String,
        var author: String,
        var category: String,
    )

    interface PoemService {
        @GET("/all.json")
        suspend fun getPoemByCoroutines(): Poem

    }
}