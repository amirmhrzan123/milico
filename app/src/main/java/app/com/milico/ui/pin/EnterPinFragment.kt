package app.com.milico.ui.pin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentEnterPinBinding
import app.com.milico.ui.popUpView.ForgetPopUpFragment
import org.koin.android.ext.android.inject

class EnterPinFragment : BaseFragment<FragmentEnterPinBinding>() {

    private val enterPinViewModel : EnterPinViewModel by inject()
    private var forgetPopUpFragment: ForgetPopUpFragment?=null



    companion object {
        const val TAG: String = "EnterPinFragment"
        fun newInstance(): EnterPinFragment = EnterPinFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()
    }

    override fun getLayout(): Int = R.layout.fragment_enter_pin


    override fun initBinder() {
        dataBinding.viewModel = enterPinViewModel.apply {



            okPressedEvent.observe(this@EnterPinFragment, Observer {

            })


            forgottenPasswordEvent.observe(baseActivity, Observer {

                openPopUpFragment()
            })

        }
    }

    fun openPopUpFragment(){
        forgetPopUpFragment= ForgetPopUpFragment.newInstance()
        forgetPopUpFragment!!.show(baseActivity.fragmentManager,ForgetPopUpFragment.TAG)
    }



}


