package app.com.milico.ui.redeem

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentRedeemBinding
import org.koin.android.ext.android.inject

class RedeemFragment:BaseFragment<FragmentRedeemBinding>() {

    private val redeemViewModel: RedeemViewModel by inject()


    companion object {
        const val TAG: String = "RedeemFragment"
        fun newInstance():RedeemFragment{
            return RedeemFragment()
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinder()
    }

    override fun getLayout(): Int = R.layout.fragment_redeem

    override fun initBinder() {

        dataBinding.rvGiftsCards.apply {
            val layoutManager = LinearLayoutManager(baseActivity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            this.layoutManager = layoutManager
            dataBinding.viewModel?.let {
                adapter = RedeemAdapter(it)
            }

        }



    }


}