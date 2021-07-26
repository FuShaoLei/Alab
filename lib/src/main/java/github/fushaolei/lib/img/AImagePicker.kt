package github.fushaolei.lib.img

import android.app.Activity

/**
 * ImagePicker工具类
 */
object AImagePicker {
    val SELECTED_IMG = "selected_img"

    fun open(activity: Activity,requestCode:Int) {
        AImagePickerActivity.openActivity(activity, requestCode)
    }
}