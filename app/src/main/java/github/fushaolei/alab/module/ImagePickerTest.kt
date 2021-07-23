package github.fushaolei.alab.module

import android.Manifest
import android.content.Intent
import github.fushaolei.alab.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.img.AImagePicker
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.APermission
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.act_image_selector.*

class ImagePickerTest : ABaseActivity() {
    private val REQUST_CODE = 111
    override fun initView() {
        APermission.request(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) { allGranted, denieList ->
            if (allGranted) {
                AToast.show("有权限")
            } else {
                AToast.show("无权限")
            }
        }
        btn_select_photo.setOnClickListener {
            AImagePicker.open(this, REQUST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUST_CODE && resultCode == RESULT_OK && data != null) {
            var pathList = data.getStringArrayListExtra(AImagePicker.SELECTED_IMG)
            pathList?.forEach {
                ALog.show("pathList = $it")
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.act_image_selector
    }
}