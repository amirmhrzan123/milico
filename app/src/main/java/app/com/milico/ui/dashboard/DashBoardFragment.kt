package app.com.milico.ui.dashboard

import android.os.Bundle
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentDashboardBinding

class DashBoardFragment: BaseFragment<FragmentDashboardBinding>() {

    private val getDashBoardModel: DashBoardModel by lazy{
        arguments!!.getParcelable(DashBoardFragment.DASHBOARDMODEL) as DashBoardModel
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


    override fun getLayout(): Int = R.layout.fragment_dashboard

    override fun initBinder() {
    }
}