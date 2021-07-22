package github.fushaolei.lib.test.img

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import github.fushaolei.lib.R
import github.fushaolei.lib.test.Alab
import github.fushaolei.lib.test.base.ARecyclerAdapter
import github.fushaolei.lib.test.base.ARecyclerViewHolder
import github.fushaolei.lib.test.entitiy.Image

class AImagePickerAdapter(dataList: MutableList<Image>) :
    ARecyclerAdapter<Image, AImagePickerAdapter.ViewHolder>(
        dataList) {

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

    override fun convert(holder: ViewHolder, item: Image) {
        Glide.with(Alab.getAppContext())
            .load(item.uri)
            .into(holder.image)
    }
}