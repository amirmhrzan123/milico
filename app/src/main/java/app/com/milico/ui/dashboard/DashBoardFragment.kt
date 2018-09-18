package app.com.milico.ui.dashboard

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.util.Log
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentDashboardBinding
import app.com.milico.ui.main.IFragmentListener
import com.google.gson.Gson
import org.koin.android.ext.android.inject

class DashBoardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel: DashBoardViewModel by inject()

    val gson: Gson by inject()
    private var iFragmentListener: IFragmentListener? = null

    private val getDashBoardModel: DashBoardModel.ResponseModel by lazy {
        arguments?.getParcelable(DashBoardFragment.DASHBOARDMODEL) as DashBoardModel.ResponseModel
    }


    companion object {
        const val TAG = "DashboardFragment"
        const val DASHBOARDMODEL = "DashboardModel"
        fun newInstance(dashBoardModel: DashBoardModel.ResponseModel?): DashBoardFragment {
            val dashBoardFragment = DashBoardFragment()
            val bundle = Bundle()
            bundle.putParcelable(DASHBOARDMODEL, dashBoardModel)
            dashBoardFragment.arguments = bundle
            return dashBoardFragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IFragmentListener) {
            iFragmentListener = context
        }
    }


    override fun getLayout(): Int = R.layout.fragment_dashboard

    override fun initBinder() {

//        Log.d("dashboard model",gson.toJson(getDashBoardModel))


        dataBinding.viewModel = dashboardViewModel.apply {
            setFields(getDashBoardModel.data.cardInfo.name,
                    getDashBoardModel.data.cardInfo.membershipStatus,
                    getDashBoardModel.data.cardInfo.email,
                    getDashBoardModel.data.cardInfo.membershipExpiry,
                    getDashBoardModel.data.cardInfo.loyaltyValue,
                    getDashBoardModel.data.cardInfo.loyaltyPoint)
            redeemClickEvent.observe(this@DashBoardFragment, Observer {
                iFragmentListener?.openRedeemPage(getDashBoardModel)
            })


        }

    }
}