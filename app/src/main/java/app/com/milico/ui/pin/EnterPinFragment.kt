package app.com.milico.ui.pin

import android.arch.lifecycle.Observer
import android.content.Context
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentEnterPinBinding
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.ui.popUpView.ForgetPopUpFragment
import app.com.milico.util.extensions.showAlert
import app.com.milico.util.extensions.showConfirmationDialog
import org.koin.android.ext.android.inject

class EnterPinFragment : BaseFragment<FragmentEnterPinBinding>() {

    private val enterPinViewModel: EnterPinViewModel by inject()
    private var forgetPopUpFragment: ForgetPopUpFragment? = null
    private var iFragmentListener: IFragmentListener? = null


    companion object {
        const val TAG: String = "EnterPinFragment"
        fun newInstance(): EnterPinFragment = EnterPinFragment()
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IFragmentListener) {
            iFragmentListener = context
        }
    }

    override fun getLayout(): Int = R.layout.fragment_enter_pin

    override fun initBinder() {
        dataBinding.viewModel = enterPinViewModel.apply {


            okPressedEvent.observe(this@EnterPinFragment, Observer {

                iFragmentListener?.openDashBoard(it!!)
            })


            forgottenPasswordEvent.observe(baseActivity, Observer {

                openPopUpFragment()
            })

            alertMessageEvent.observe(this@EnterPinFragment, Observer {
                it?.let {
                    activity?.showAlert(it)
                }
            })

        }
    }

    fun openPopUpFragment() {
        forgetPopUpFragment = ForgetPopUpFragment.newInstance()
        forgetPopUpFragment!!.show(baseActivity.fragmentManager, ForgetPopUpFragment.TAG)
    }
}


