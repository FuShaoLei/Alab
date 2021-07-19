package github.fushaolei.alab.module

import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.ARetrofit
import kotlinx.android.synthetic.main.act_retrofit.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ARetrofitActivity : ABaseActivity() {
    // 随机诗词api:https://v1.jinrishici.com/all.json

    private val myScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }


    override fun initView() {
        var testService = ARetrofit.getService("https://v1.jinrishici.com", PoemService::class.java)
        btn_update.setOnClickListener {
            myScope.launch {
                var getP = testService!!.getPoem()
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
        suspend fun getPoem(): Poem
    }
}