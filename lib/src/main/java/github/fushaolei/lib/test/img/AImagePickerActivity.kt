package github.fushaolei.lib.test.img

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import github.fushaolei.lib.R
import github.fushaolei.lib.test.base.ABaseActivity
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.entitiy.Image
import github.fushaolei.lib.test.utils.ALog
import github.fushaolei.lib.test.utils.AToast
import kotlinx.android.synthetic.main.alab_act_image_selector.*

class AImagePickerActivity : ABaseActivity() {
    private lateinit var adapter: AImagePickerAdapter
    override fun initView() {

        var lm = GridLayoutManager(this, 3)


        AImagePickerModel.loadImage(this, object : AImagePickerModel.DataCallback {
            override fun onSuccess(images: ArrayList<Image>) {
                images.forEach {
                    ALog.show(it.toString())
                }
                adapter = AImagePickerAdapter(images)
                rv_image.layoutManager = lm
                rv_image.adapter = adapter


                adapter.setOnItemClickListener(object : ARecyclerAdapter.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        var status: ImageView = view.findViewById(R.id.iv_status)
                        status.setImageResource(R.drawable.ic_select)
                    }
                })
            }
        })

        btn_finish.setOnClickListener {
            AToast.show("这个还没做呢")
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