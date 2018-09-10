package app.com.milico.ui.redeem

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()

    }

    override fun getLayout(): Int = R.layout.fragment_redeem

    override fun initBinder() {

        dataBinding.viewModel = redeemViewModel.apply {
            getGiftsCards()

            itemClickEvent.observe(this@RedeemFragment, Observer {
                Log.d("id",it.toString())
                dataBinding.rvGiftsCards.apply {
                    if (it != null) {
                        smoothScrollToPosition(it)
                    }

                }
            })

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


}