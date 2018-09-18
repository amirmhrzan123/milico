package app.com.milico.ui.redeemList

import android.app.Dialog
import android.arch.lifecycle.Observer
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
import app.com.milico.ui.main.MainViewModel
import app.com.milico.util.extensions.convertDpToPixel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class RedeemValueDialog: BaseDialogFragment<LayoutRedeemValueBinding>(){

    private val redeemViewModel: MainViewModel by sharedViewModel()


    private var editQuantityDialog: EditQuantityDialog? = null

    var DIALOG_HEIGHT : Int = 0

    val HEIGHT_FACTOR = 0.4


    companion object {

        const val TAG: String = "RedeemValue"

        fun newInstance(): RedeemValueDialog {
            return RedeemValueDialog()
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
        p.x = redeemViewModel.getXvalue() // about half of confirm button size left of source view
        p.y = redeemViewModel.getYvalue() + (HEIGHT_FACTOR*DIALOG_HEIGHT).toInt() - convertDpToPixel(DIALOG_HEIGHT).toInt()// above source view
        window.attributes = p
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        DIALOG_HEIGHT = resources.getDimension(R.dimen.dialog_height).toInt()
        return dialog
    }


    override fun onStart() {
        super.onStart()
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Dialog);
        dialog.window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

    }


}