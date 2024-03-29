package github.fushaolei.lib.img

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import github.fushaolei.lib.R
import github.fushaolei.lib.Alab
import github.fushaolei.lib.base.ARecyclerAdapter
import github.fushaolei.lib.base.ARecyclerViewHolder
import github.fushaolei.lib.entitiy.AlabImage
import java.util.ArrayList

class AImagePickerAdapter(dataList: MutableList<AlabImage>) :
    ARecyclerAdapter<AlabImage, AImagePickerAdapter.ViewHolder>(
        dataList) {

    // 选中的图片
    private var selectList: ArrayList<AlabImage>? = null

    init {
        selectList = ArrayList()
    }

    class ViewHolder(itemView: View) : ARecyclerViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.iv_image)
        var status: ImageView = itemView.findViewById(R.id.iv_status)

    }

    override fun onReturnVH(view: View): ViewHolder {
        return ViewHolder(view)
    }

    override fun getItemLayout(): Int {
        return R.layout.alab_item_image
    }

    override fun convert(holder: ViewHolder, item: AlabImage) {
        Glide.with(Alab.getAppContext())
            .load(item.uri)
            .into(holder.image)


        holder.itemView.setOnClickListener {
            if (selectList?.contains(item) == true) {
                holder.status.setImageResource(R.drawable.alab_ic_un_select)
                selectList?.remove(item)
            } else {
                holder.status.setImageResource(R.drawable.alab_ic_select)
                selectList?.add(item)
            }
        }
    }

    fun getImageList(): ArrayList<AlabImage>? {
        return selectList
    }

}