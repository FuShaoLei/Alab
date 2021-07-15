package github.fushaolei.lib.test.utils

import android.widget.Toast
import github.fushaolei.lib.test.Alab

object AToast {
    fun show(text: String) {
        Toast.makeText(Alab.getAppContext(), text, Toast.LENGTH_SHORT).show()
    }
}