package app.com.milico.base

import android.app.ProgressDialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity<V: ViewDataBinding> : AppCompatActivity() {
    protected lateinit var dataBinding: V
    private lateinit var progressDialog: ProgressDialog
    private var toolbar: Toolbar? = null

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initBinder()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        progressDialog = ProgressDialog(this)
        initBinder()
    }


    private fun performDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getLayout())
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    fun showProgressDialog(message: Int = 0) {
       // var messageText = getString(R.string.msg_loading)
        var messageText = "Loading"
        if (message != 0) {
            messageText = getString(message)
        }
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setMessage(messageText)
        progressDialog.show()
    }


    fun hideProgressDialog() {
        progressDialog.cancel()
    }

}