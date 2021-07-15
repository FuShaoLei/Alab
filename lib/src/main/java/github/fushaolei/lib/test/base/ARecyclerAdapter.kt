package github.fushaolei.lib.test.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ARecyclerAdapter<T, VH : ARecyclerViewHolder>(var dataList: List<T>) :
    RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
//        var view = LayoutInflater.from(parent.context).inflate(getItemLayout(), parent, false)
//        return VH(view)
    }

    abstract fun getItemLayout(): Int
}