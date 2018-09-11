package app.com.milico.ui.popUpView

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import app.com.milico.R
import app.com.milico.base.BaseDialogFragment
import app.com.milico.databinding.LayoutInfoAppBinding
import kotlinx.android.synthetic.main.layout_info_app.*

class InfoPopUpFragment: BaseDialogFragment<LayoutInfoAppBinding>() {


    private val info: String by lazy {
        arguments!!.getString("INFOTEXT")
    }

    override fun getLayout(): Int = R.layout.layout_info_app

    override fun initBinder() {
    }

    companion object {
        const val TAG: String = "ForgetPopUpFragment"
        const val INFOTEXT: String = "InfoText"
        fun newInstance(text:String):InfoPopUpFragment{
            val infoPopUpFragment = InfoPopUpFragment()
            val bundle= Bundle()
            bundle.putString(INFOTEXT,text)
            infoPopUpFragment.arguments = bundle
            return infoPopUpFragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_text.text = info
        iv_cross_info.setOnClickListener { dialog.dismiss() }
        mainLayout_info.setOnClickListener { dialog.dismiss() }
        info_layout.setOnClickListener {  }

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
        dialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

    }


}