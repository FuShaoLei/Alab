package github.fushaolei.lib.test.utils

import android.content.Context
import android.content.SharedPreferences
import github.fushaolei.lib.test.Alab

object ACache {
    private val sp: SharedPreferences by lazy {
        Alab.getAppContext().getSharedPreferences("alab", Context.MODE_PRIVATE)
    }

    fun save(key: String, value: String) {
        sp.edit().putString(key, value).apply()
    }

    fun get(key: String): String? {
        return sp.getString(key, null)
    }
}