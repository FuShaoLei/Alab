package github.fushaolei.lib.utils

import android.widget.Toast
import github.fushaolei.lib.Alab

/**
 * Toast工具类
 * Created by fushaolei on 2021/07/15
 */
object AToast {
    fun show(text: String) {
        Toast.makeText(Alab.getAppContext(), text, Toast.LENGTH_SHORT).show()
    }
}