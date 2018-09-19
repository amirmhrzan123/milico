package app.com.milico.ui.dashboard

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentDashboardBinding
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.ui.main.MainViewModel
import com.google.gson.Gson
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DashBoardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel: DashBoardViewModel by viewModel()

    private val mainViewModel : MainViewModel by sharedViewModel()

    val gson: Gson by inject()
    private var iFragmentListener: IFragmentListener? = null

    private val cardData: DashBoardModel.Data by lazy {
        arguments?.getParcelable(DashBoardFragment.DASHBOARDMODEL) as DashBoardModel.Data
    }

    companion object {
        const val TAG = "DashboardFragment"
        const val DASHBOARDMODEL = "DashboardModel"
        fun newInstance(dashBoardModel: DashBoardModel.Data?): DashBoardFragment {
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
        mainViewModel.setDataModels(cardData)

//        Log.d("dashboard model",gson.toJson(userData))
        dataBinding.viewModel = dashboardViewModel.apply {

            redeemClickEvent.observe(this@DashBoardFragment, Observer {
                iFragmentListener?.openRedeemPage(cardData)
            })
        }

        dataBinding.model = cardData

    }
}