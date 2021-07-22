package github.fushaolei.lib.test.mvp

abstract class AMBasePresenter<V : AMBaseView> {
    protected var baseView: AMBaseView? = null

    /**
     * 绑定view
     */
    abstract fun attachView(view: V)

    /**
     * 解绑
     */
    fun detachView(){
        if (baseView!=null){
            baseView = null
        }
    }
}