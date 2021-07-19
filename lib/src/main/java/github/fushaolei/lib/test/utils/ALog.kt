package github.fushaolei.lib.test.utils

import android.util.Log

/**
 * Log工具类
 * Created by fushaolei on 2021/07/15
 */
object ALog {
    private var isOpen = true
    private var tag = "[ALog]"

    fun show(text: String) {
        if (!isOpen) return
        var ts = getTargetStackTraceElement()
        Log.e(tag, "┌──────────────────────────────────────────────────")
        Log.e(tag, "│ (${ts?.fileName}:${ts?.lineNumber})")
        Log.e(tag, "├──────────────────────────────────────────────────")
        Log.e(tag, "│ $text")
        Log.e(tag, "└──────────────────────────────────────────────────")
    }

    /**
     * 关闭
     */
    fun close() {
        isOpen = false
    }

    /**
     * 打开
     */
    fun open() {
        isOpen = true
    }


    /**
     * 获取堆栈信息，此处参考的是鸿洋大佬的文章
     */
    private fun getTargetStackTraceElement(): StackTraceElement? {
        var targetStackTrace: StackTraceElement? = null
        var shouldTrace = false
        var stackTrace = Thread.currentThread().stackTrace
        for (stackTraceElement in stackTrace) {
            var isLogMethod = stackTraceElement.className.equals(ALog::class.java.name)
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement
                break
            }
            shouldTrace = isLogMethod
        }
        return targetStackTrace
    }
}