package github.fushaolei.alab

import android.app.Application
import github.fushaolei.lib.test.Alab

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Alab.init(this)
    }
}