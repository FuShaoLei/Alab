package github.fushaolei.alab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import github.fushaolei.lib.test.Alab
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ALog.show("hello log world!")
        tv_text.setOnClickListener {
            AToast.show("you click textview ！！！")
        }
    }
}