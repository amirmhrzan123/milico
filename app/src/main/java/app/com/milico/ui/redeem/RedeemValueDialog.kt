package app.com.milico.ui.redeem

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import app.com.milico.R
import app.com.milico.base.BaseDialogFragment
import app.com.milico.databinding.LayoutRedeemValueBinding
import app.com.milico.util.extensions.convertDpToPixel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class RedeemValueDialog: BaseDialogFragment<LayoutRedeemValueBinding>(){

    private val redeemViewModel: RedeemViewModel by sharedViewModel()

    lateinit var iRedeemValueListener: IRedeemValueListener

    private var editQuantityDialog: EditQuantityDialog? = null




    private val getX: Int by lazy {
        arguments!!.getInt(X)
    }

    private val getY: Int by lazy{
        arguments!!.getInt(Y)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is IRedeemValueListener){
            iRedeemValueListener = context
        }
    }

    companion object {

        const val TAG: String = "RedeemValue"
        const val X: String = "xValue"
        const val Y: String = "yValue"
        fun newInstance(x: Int,y:Int): RedeemValueDialog {
            val redeemValueDialog = RedeemValueDialog()
            val bundle= Bundle()
            bundle.putInt(X,x)
            bundle.putInt(Y,y)
            redeemValueDialog.arguments = bundle
            return redeemValueDialog
        }
    }



    override fun getLayout(): Int = R.layout.layout_redeem_value

    override fun initBinder() {
        dataBinding.viewModel = redeemViewModel.apply {
           buttonClickEvent.observe(this@RedeemValueDialog, Observer {
                Log.d("xyvalueDialgo",getXvalue().toString()+"  "+getYvalue().toString())
                editQuantityDialog = EditQuantityDialog.newInstance(it.toString())
               editQuantityDialog!!.show(fragmentManager, RedeemValueDialog.TAG)

               dismiss()
           })
        }

        setDialogPosition()
    }



    private fun setDialogPosition() {

        val window = dialog.window
        window.setGravity(Gravity.START or Gravity.TOP)
        val p = window.attributes
        p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
        p.x = getX // about half of confirm button size left of source view
        Log.d("height",p.height.toString())
        p.y = getY + (0.20*400).toInt() - convertDpToPixel(450).toInt()// above source view
        window.attributes = p
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        // dialog.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        return dialog
    }


    override fun onStart() {
        super.onStart()
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Dialog);
        dialog.window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

    }

    interface IRedeemValueListener{
        fun openQuantityDialog()
    }

}