package app.com.milico.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseDialogFragment<V : ViewDataBinding> : DialogFragment() {
    protected lateinit var baseActivity: BaseActivity<*>
    protected lateinit var dataBinding: V

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initBinder()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            baseActivity = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        performViewBinding(inflater, container)
        initBinder()
        return dataBinding.root
    }

    private fun performViewBinding(inflater: LayoutInflater, container: ViewGroup?) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
    }
}