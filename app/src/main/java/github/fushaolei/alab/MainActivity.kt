package github.fushaolei.alab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import github.fushaolei.lib.test.TestLib

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result = TestLib.plus(10, 11)
        Log.e("MainActivity => ", "result = $result")
    }
}