package github.fushaolei.lib.test.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity基类
 * Created by fushaolei on 2021/07/15
 */
abstract class ABaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    abstract fun initView()

    abstract fun getLayoutId(): Int
}