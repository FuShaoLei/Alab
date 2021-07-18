package github.fushaolei.lib.test.utils

import android.widget.Toast
import github.fushaolei.lib.test.Alab

/**
 * Toast工具类
 */
object AToast {
    fun show(text: String) {
        Toast.makeText(Alab.getAppContext(), text, Toast.LENGTH_SHORT).show()
    }
}