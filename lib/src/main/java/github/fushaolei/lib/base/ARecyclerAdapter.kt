package github.fushaolei.lib.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Recyclerview Adapter基类
 * Created by fushaolei on 2021/07/15
 */
abstract class ARecyclerAdapter<T, VH : ARecyclerViewHolder>(var dataList: MutableList<T>) :
    RecyclerView.Adapter<VH>() {

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    /**
     * 暂且如此写
     */
    abstract fun onReturnVH(view: View): VH

    abstract fun getItemLayout(): Int


    abstract fun convert(holder: VH, item: T)

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var view = LayoutInflater.from(parent.context).inflate(getItemLayout(), parent, false)

        return onReturnVH(view)
    }

    inline fun <reified VH> createVH(vararg view: Any): VH {
        val clz = VH::class.java
        val paramTypes = view.map { it::class.java }.toTypedArray()
        val mCraetor = clz.getDeclaredConstructor(*paramTypes)
        mCraetor.isAccessible = true
        return mCraetor.newInstance(* view)

    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        convert(holder, dataList[position])
        if (listener != null) {
            holder.itemView.setOnClickListener {
                listener!!.onItemClick(it, position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    /**
     * 替换数据
     */
    fun replaceData(datas: List<T>) {
        if (datas != dataList) {
            dataList.clear()
            dataList.addAll(datas)
            notifyDataSetChanged()
        }
    }

    /**
     * 增添数据
     */
    fun addData(datas: List<T>) {
        dataList.addAll(datas)
        notifyDataSetChanged()
    }

    /**
     * 增添数据
     */
    fun addData(data: T) {
        dataList.add(data)
    }
}