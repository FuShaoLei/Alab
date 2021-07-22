package github.fushaolei.alab.module

import android.Manifest
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.img.AImagePicker
import github.fushaolei.lib.test.utils.APermission
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_image_selector.*

class AImageTestActivity : ABaseActivity() {
    override fun initView() {
        APermission.request(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) { allGranted, denieList ->
            if (allGranted) {
                AToast.show("有权限")
            } else{
                AToast.show("无权限")
            }
        }
        btn_select_photo.setOnClickListener {
            AImagePicker.open(this)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.act_image_selector
    }
}