package github.fushaolei.lib.test.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * 协程工具类
 * （ps：其实我也不知道这样正不正确。。。。水平还是太低了，就先这样大胆去做吧）
 */
object AScope {
    private val mScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    fun getScope(): CoroutineScope {
        return mScope
    }
}