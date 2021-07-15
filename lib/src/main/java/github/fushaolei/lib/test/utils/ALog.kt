package github.fushaolei.lib.test.utils

import android.util.Log

object ALog {
    fun show(text: String) {
        var template = """\n
            ┌───────────────
            │$text
            └───────────────
        """.trimIndent()
        Log.e("==> ",template)
    }
}