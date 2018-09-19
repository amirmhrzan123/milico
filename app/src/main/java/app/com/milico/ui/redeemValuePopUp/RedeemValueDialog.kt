package app.com.milico.ui.redeemValuePopUp

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import app.com.milico.R
import app.com.milico.base.BaseDialogFragment
import app.com.milico.databinding.LayoutRedeemValueBinding
import app.com.milico.ui.editQuantityDialog.EditQuantityDialog
import app.com.milico.ui.main.MainViewModel
import app.com.milico.util.extensions.convertDpToPixel
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class RedeemValueDialog: BaseDialogFragment<LayoutRedeemValueBinding>(){

    private val mainViewModel: MainViewModel by sharedViewModel()

    private val redeemViewModel: RedeemValueViewModel by viewModel()


    private var editQuantityDialog: EditQuantityDialog? = null

    var DIALOG_HEIGHT : Int = 0

    val HEIGHT_FACTOR = 0.4

    val gson = Gson()

    private val getXValue: Int by lazy {
        arguments!!.getInt(XVALUE)
    }

    private val getYValue:Int by lazy{
        arguments!!.getInt(YVALUE)
    }


    companion object {

        const val TAG: String = "RedeemValue"
        const val XVALUE: String = "Xvalue"
        const val YVALUE: String = "Yvalue"

        fun newInstance(x:Int,y:Int): RedeemValueDialog {
            val redeemValueDialog=RedeemValueDialog()
            val bundle = Bundle()
            bundle.putInt(XVALUE,x)
            bundle.putInt(YVALUE,y)
            redeemValueDialog.arguments = bundle
            return redeemValueDialog
        }
    }



    override fun getLayout(): Int = R.layout.layout_redeem_value

    override fun initBinder() {
        dataBinding.viewModel = redeemViewModel.apply {
            clubPointsAvailable = mainViewModel.dataModel.cardInfo!!.totalRemainingPoints
            ratio = mainViewModel.dataModel.cardInfo!!.ratio
           buttonClickEvent.observe(this@RedeemValueDialog, Observer {
               editQuantityDialog = EditQuantityDialog.newInstance(it.toString(),getXValue,getYValue)
               editQuantityDialog!!.show(fragmentManager, TAG)

               dismiss()
           })
        }

        dataBinding.model = mainViewModel.dataModel

        setDialogPosition()
    }


    private fun setDialogPosition() {
        val window = dialog.window
        window.setGravity(Gravity.START or Gravity.TOP)
        val p = window.attributes
        p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
        p.x = getXValue // about half of confirm button size left of source view
        p.y = getYValue + (HEIGHT_FACTOR*DIALOG_HEIGHT).toInt() - convertDpToPixel(DIALOG_HEIGHT).toInt()// above source view
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