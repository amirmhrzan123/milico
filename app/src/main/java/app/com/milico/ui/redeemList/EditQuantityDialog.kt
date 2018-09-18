package app.com.milico.ui.redeemList

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import app.com.milico.R
import app.com.milico.base.BaseDialogFragment
import app.com.milico.databinding.LayoutEditQuantityBinding
import app.com.milico.ui.main.MainViewModel
import app.com.milico.util.extensions.convertDpToPixel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class EditQuantityDialog:BaseDialogFragment<LayoutEditQuantityBinding>() {

    private val redeemViewModel:MainViewModel by sharedViewModel()

    var DIALOG_HEIGHT : Int = 0

    val HEIGHT_FACTOR = 0.5

    private val getPrice: String by lazy{
        arguments!!.getString(PRICE,"")
    }


    companion object {
        const val PRICE = "PRICE"

        fun newInstance(price: String):EditQuantityDialog{
            val editQuantityDialog= EditQuantityDialog()
            val bundle = Bundle()
            bundle.putString(PRICE,price)
            editQuantityDialog.arguments = bundle
            return editQuantityDialog
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        DIALOG_HEIGHT = resources.getDimension(R.dimen.edit_dialog_height).toInt()

        return dialog
    }

    private fun setDialogPosition() {

        val window = dialog.window
        window.setGravity(Gravity.START or Gravity.TOP)
        val p = window.attributes
        p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
        p.x = redeemViewModel.getXvalue() // about half of confirm button size left of source view
        Log.d("height",p.height.toString())
        p.y = redeemViewModel.getYvalue() + (HEIGHT_FACTOR*DIALOG_HEIGHT).toInt() - convertDpToPixel(DIALOG_HEIGHT).toInt()// above source view
        window.attributes = p
    }

    override fun getLayout(): Int = R.layout.layout_edit_quantity

    override fun initBinder() {
        dataBinding.viewModel = redeemViewModel.apply {
            setPriceForEdit(getPrice)
        }
        setDialogPosition()

    }
}