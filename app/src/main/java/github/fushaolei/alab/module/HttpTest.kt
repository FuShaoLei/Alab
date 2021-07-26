package github.fushaolei.alab.module

import github.fushaolei.alab.R
import github.fushaolei.lib.base.ABaseActivity
import github.fushaolei.lib.utils.ALog
import kotlinx.android.synthetic.main.act_http.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class HttpTest : ABaseActivity() {
     override fun initView() {
        btn_update.setOnClickListener {
            thread {
                var connection: HttpURLConnection? = null
                try {
                    val response = StringBuilder()
                    val url = URL("https://v1.jinrishici.com/all.json")
                    connection= url.openConnection() as HttpURLConnection
                    connection.connectTimeout = 8000
                    connection.readTimeout = 8000
                    connection.requestMethod = "GET"
                    val input = connection.inputStream

                    val reader =  BufferedReader(InputStreamReader(input))
                    reader.use {
                        reader.forEachLine {
                            response.append(it)
                        }
                    }
                    ALog.show("接受到的是：${response.toString()}")
                }catch (e:Exception){
                    e.printStackTrace()
                }finally {
                    connection?.disconnect()
                }
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.act_http
    }
}