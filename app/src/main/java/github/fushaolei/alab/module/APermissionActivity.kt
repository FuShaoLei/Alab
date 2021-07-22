package github.fushaolei.alab.module

import android.Manifest
import android.content.Intent
import android.net.Uri
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.utils.APermission
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_permission.*

class APermissionActivity : ABaseActivity() {
    override fun initView() {
        btn_get_permission.setOnClickListener {
            APermission.request(this, Manifest.permission.CALL_PHONE) { allGranted, denieList ->
                if (allGranted) {
                    AToast.show("权限已获取")
                    call()
                } else {
                    AToast.show("权限未获取")
                }
            }
        }
    }

    private fun call() {
        try {
            var intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:1008611")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.act_permission
    }
}