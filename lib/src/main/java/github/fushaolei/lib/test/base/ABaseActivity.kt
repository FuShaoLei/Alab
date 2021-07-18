package github.fushaolei.lib.test.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class ABaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    abstract fun initView()

    abstract fun getLayoutId(): Int
}