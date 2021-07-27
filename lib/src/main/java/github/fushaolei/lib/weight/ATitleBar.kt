package github.fushaolei.lib.weight

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import github.fushaolei.lib.R
import kotlinx.android.synthetic.main.alab_title_bar.view.*

/**
 * 标题栏自定义控件
 */
class ATitleBar(context: Context, attr: AttributeSet) : FrameLayout(context, attr) {
    private var onCenterClickListener: OnCenterClickListener? = null
    private var onLeftClickListener: OnLeftClickListener? = null
    private var onRightClickListener: OnRightClickListener? = null

    init {
        initView(context, attr)
    }

    fun initView(context: Context, attr: AttributeSet) {
        val inflate = LayoutInflater.from(context).inflate(R.layout.alab_title_bar, this)

        val typeArray = context.obtainStyledAttributes(attr, R.styleable.ATitleBar)

        val bgColor = typeArray.getResourceId(R.styleable.ATitleBar_BackgroundColor, R.color.white)
        val centerText = typeArray.getString(R.styleable.ATitleBar_CenterText)
        val rightText = typeArray.getString(R.styleable.ATitleBar_RightText)

        val centerTextColor = typeArray.getColor(R.styleable.ATitleBar_CenterTextColor,
            resources.getColor(R.color.black))
        val rightTextColor = typeArray.getColor(R.styleable.ATitleBar_RightTextColor,
            resources.getColor(R.color.black))


        setCenterText(centerText)
        setRightText(rightText)
        setBgColor(bgColor)
        tv_center.setTextColor(centerTextColor)
        tv_right.setTextColor(rightTextColor)

        // 监听事件
        iv_left?.setOnClickListener { v: View? ->
            if (onLeftClickListener != null) onLeftClickListener!!.onLeftClick(v)
        }
        tv_center?.setOnClickListener { v: View? ->
            if (onCenterClickListener != null) onCenterClickListener!!.onTitleClick(v)
        }
        tv_right?.setOnClickListener { v: View? ->
            if (onRightClickListener != null) onRightClickListener!!.onRightClick(v)
        }
    }

    private fun setBgColor(bgColor: Int): ATitleBar {
        fl_root.setBackgroundResource(bgColor)
        return this
    }


    private fun setRightText(rightText: String?): ATitleBar {
        tv_right.text = rightText
        return this
    }

    private fun setCenterText(centerText: String?): ATitleBar {
        tv_center.text = centerText
        return this
    }

    /**
     * 左边按钮监听
     */
    interface OnLeftClickListener {
        fun onLeftClick(v: View?)
    }

    /**
     * 标题按钮监听
     */
    interface OnCenterClickListener {
        fun onTitleClick(v: View?)
    }

    /**
     * 右边按钮监听
     */
    interface OnRightClickListener {
        fun onRightClick(v: View?)
    }

    fun setOnLeftClickListener(onLeftClickListener: OnLeftClickListener): ATitleBar {
        this.onLeftClickListener = onLeftClickListener
        return this
    }

    fun setOnCenterClickListener(onCenterClickListener: OnCenterClickListener?): ATitleBar {
        this.onCenterClickListener = onCenterClickListener
        return this
    }

    fun setOnRightClickListener(onRightClickListener: OnRightClickListener?): ATitleBar {
        this.onRightClickListener = onRightClickListener
        return this
    }


}