package app.com.milico.ui.popUpView

import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import app.com.milico.R
import kotlinx.android.synthetic.main.layout_forgetpin_popup.*

class ForgetPopUpFragment : DialogFragment() {


    companion object {
        const val TAG: String = "ForgetPopUpFragment"
        const val TEXT = "text"
        fun newInstance(text: String): ForgetPopUpFragment = ForgetPopUpFragment().apply {
            val bundle = Bundle()
            bundle.putString(TEXT, text)
            arguments = bundle
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // dialog.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.layout_forgetpin_popup, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_select_staff.text = arguments?.getString(TEXT)
        iv_cross.setOnClickListener {
            dialog.dismiss()
        }
        mainLayout.setOnClickListener {
            dialog.dismiss()
        }
        dialog_layout.setOnClickListener {

        }
    }
}