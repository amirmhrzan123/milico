package app.com.milico.ui.dashboard

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentDashboardBinding
import app.com.milico.ui.main.IFragmentListener
import org.koin.android.ext.android.inject

class DashBoardFragment: BaseFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel: DashBoardViewModel by inject()


    private var iFragmentListener: IFragmentListener ?=null

    private val getDashBoardModel: DashBoardModel by lazy{
        arguments!!.getParcelable(DashBoardFragment.DASHBOARDMODEL) as DashBoardModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()
    }

    companion object {
        const val TAG = "DashboardFragment"
        const val DASHBOARDMODEL = "DashboardModel"
        fun newInstance(dashBoardModel: DashBoardModel):DashBoardFragment{
            val dashBoardFragment = DashBoardFragment()
            val bundle = Bundle()
            bundle.putParcelable(DASHBOARDMODEL,dashBoardModel)
            dashBoardFragment.arguments = bundle
            return dashBoardFragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is IFragmentListener){
            iFragmentListener = context
        }
    }


    override fun getLayout(): Int = R.layout.fragment_dashboard

    override fun initBinder() {
        dataBinding.viewModel = dashboardViewModel.apply {
            redeemClickEvent.observe(this@DashBoardFragment, Observer {
                iFragmentListener?.openRedeemPage()
            })
        }

    }
}