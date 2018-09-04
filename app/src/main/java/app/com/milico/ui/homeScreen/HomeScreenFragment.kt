package app.com.milico.ui.homeScreen

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentHomeScreenBinding
import app.com.milico.ui.main.IFragmentListener
import org.koin.android.ext.android.inject

class HomeScreenFragment: BaseFragment<FragmentHomeScreenBinding>() {

    private val homeScreenViewModel: HomeScreenViewModel by inject()



    lateinit var iFragmentListener: IFragmentListener

    companion object {
        const val TAG: String = "HomeScreenFragment"
        fun newInstance(): HomeScreenFragment = HomeScreenFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is IFragmentListener){
            iFragmentListener = context
        }
    }

    override fun getLayout(): Int = R.layout.fragment_home_screen

    override fun initBinder() {
        dataBinding.viewModel = homeScreenViewModel.apply {
            openEnterPin.observe(this@HomeScreenFragment, Observer {
                iFragmentListener.openPinKeyScreen()
            })
        }



    }
}