package github.fushaolei.lib.test

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.lang.RuntimeException

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
        if (this.context != null) return
        this.context = context.applicationContext
    }
}