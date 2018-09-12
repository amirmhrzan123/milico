package app.com.milico.ui.homeScreen

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentHomeScreenBinding
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.util.extensions.AlertDialogCallback
import app.com.milico.util.extensions.showNotCancellableAlert
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
//            getAppDetails(Settings.Secure.getString(activity?.application?.contentResolver, Settings.Secure.ANDROID_ID))

            openEnterPin.observe(this@HomeScreenFragment, Observer {
                iFragmentListener.openPinKeyScreen()
            })

            appDetailsEvents.observe(this@HomeScreenFragment, Observer {
                iFragmentListener.hideShowToolbar()
            })

            errorEvent.observe(this@HomeScreenFragment,Observer{
                activity?.showNotCancellableAlert(it!!,object:AlertDialogCallback{
                    override fun onPositiveButtonClicked() {
                        getAppDetails(Settings.Secure.getString(activity?.application?.contentResolver, Settings.Secure.ANDROID_ID))
                    }

                    override fun onNegativeButtonClicked() {
                    }

                })
            })
        }



    }
}