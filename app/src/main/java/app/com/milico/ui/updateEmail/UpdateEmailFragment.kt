package app.com.milico.ui.updateEmail

import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentUpdateEmailBinding

/**
Created by Prajeet on 9/17/2018, 3:36 PM
 **/

class UpdateEmailFragment : BaseFragment<FragmentUpdateEmailBinding>() {
    companion object {
        fun getInstance(): UpdateEmailFragment = UpdateEmailFragment()
    }

    override fun getLayout() = R.layout.fragment_update_email

    override fun initBinder() {

    }
}