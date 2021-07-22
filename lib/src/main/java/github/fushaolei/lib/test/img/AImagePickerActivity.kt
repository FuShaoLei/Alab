package github.fushaolei.lib.test.img

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import github.fushaolei.lib.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.entitiy.AlabImage
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.alab_act_image_selector.*

/**
 * ImagePicker界面
 */
class AImagePickerActivity : ABaseActivity() {
    private lateinit var adapter: AImagePickerAdapter
    override fun initView() {

        var lm = GridLayoutManager(this, 3)


        AImagePickerModel.loadImage(this, object : AImagePickerModel.DataCallback {
            override fun onSuccess(alabImages: ArrayList<AlabImage>) {
                alabImages.forEach {
                    ALog.show(it.toString())
                }
                adapter = AImagePickerAdapter(alabImages)
                rv_image.layoutManager = lm
                rv_image.adapter = adapter

            }
        })

        tv_confirm.setOnClickListener {
            var dataList = adapter.getImageList()
            dataList?.forEach {
                ALog.show("选中的图片信息：${it.toString()}")
            }
        }


    }

    override fun getLayoutId(): Int {
        return R.layout.alab_act_image_selector
    }

    companion object {
        fun openActivity(activity: Activity) {
            var intent = Intent(activity, AImagePickerActivity::class.java)
            activity.startActivity(intent)
        }
    }
}