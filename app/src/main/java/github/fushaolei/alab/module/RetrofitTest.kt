package github.fushaolei.alab.module

import github.fushaolei.alab.R
import github.fushaolei.lib.base.ABaseActivity
import github.fushaolei.lib.utils.AScope
import github.fushaolei.lib.utils.ALog
import github.fushaolei.lib.utils.ARetrofit
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