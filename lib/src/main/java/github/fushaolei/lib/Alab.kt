package github.fushaolei.lib

import android.annotation.SuppressLint
import android.content.Context
import java.lang.RuntimeException

/**
 * 初始化类
 * Created by fushaolei on 2021/07/15
 */
@SuppressLint("StaticFieldLeak")
object Alab {
    private var context: Context? = null

    fun getAppContext(): Context {
        if (context == null) {
            throw RuntimeException("Please call [Alab.init(context)] first, FUCK YOU!")
        } else {
            return context as Context
        }
    }

    fun init(context: Context) {
        if (Alab.context != null) return
        Alab.context = context.applicationContext
    }
}