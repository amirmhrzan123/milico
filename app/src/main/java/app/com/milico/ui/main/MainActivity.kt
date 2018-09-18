package app.com.milico.ui.main

import android.app.ActivityManager
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivityMainBinding
import app.com.milico.ui.dashboard.DashBoardFragment
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.ui.homeScreen.HomeScreenFragment
import app.com.milico.ui.homeScreen.HomeScreenViewModel
import app.com.milico.ui.pin.EnterPinFragment
import app.com.milico.ui.popUpView.ForgetPopUpFragment
import app.com.milico.ui.popUpView.InfoPopUpFragment
import app.com.milico.ui.redeem.RedeemFragment
import app.com.milico.ui.review.ReviewFragment
import app.com.milico.ui.updateEmail.UpdateEmailFragment
import app.com.milico.util.extensions.addFragmentToActivity
import app.com.milico.util.extensions.replaceFragmentInActivity
import app.com.milico.util.extensions.showAlert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding>(), IFragmentListener {
    override fun openUpdateEmail() {
        addFragmentToActivity(UpdateEmailFragment.getInstance(), R.id.fl_container, RedeemFragment.TAG)
    }

    override fun openReview() {
        addFragmentToActivity(ReviewFragment.getInstance(), R.id.fl_container, RedeemFragment.TAG)
    }

    private val WARNING_TIMEOUT: Long = 20000 // 20 second
    private val DISCONNECT_TIMEOUT: Long = 30000 // 20 second

    private val forgetPopUpFragment by lazy {
        ForgetPopUpFragment.newInstance(resources.getString(R.string.inactive_msg))
    }

    private val mainViewModel: MainViewModel by inject()

    private var infoPopUpFragment: InfoPopUpFragment? = null

    companion object {
        fun start(context: Context) {
            context.startActivity<MainActivity>()
        }
    }

    override fun openHomeScreen() {
        replaceFragmentInActivity(HomeScreenFragment.newInstance(), R.id.fl_container, HomeScreenFragment.TAG)
    }

    override fun openPinKeyScreen() {
        replaceFragmentInActivity(EnterPinFragment.newInstance(), R.id.fl_container, EnterPinFragment.TAG)
    }

    override fun openDashBoard(dashboardModel: DashBoardModel.Data) {
        replaceFragmentInActivity(DashBoardFragment.newInstance(dashboardModel), R.id.fl_container, DashBoardFragment.TAG)
    }

    override fun openRedeemPage(dashboardModel: DashBoardModel.Data) {
        addFragmentToActivity(RedeemFragment.newInstance(dashboardModel), R.id.fl_container, RedeemFragment.TAG)
    }

    //show toolbar if the device has been registered to club only
    override fun hideShowToolbar() {
        mainViewModel.setFirstTime()
    }

    override fun getLayout(): Int = R.layout.activity_main

    override fun initBinder() {
        dataBinding.viewModel = mainViewModel.apply {
            infoClicked.observe(this@MainActivity, Observer {
                it?.let {
                    Log.d("string", it)
                    openPopUpInfo(it)
                }
            })

            goToHome.observe(this@MainActivity, Observer {
                mainViewModel.listGiftsCards.get()?.let {
                    openDashBoard(it)
                }
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openHomeScreen()
        initBinder()
//        openRedeemPage()

    }

    private fun openPopUpInfo(texts: String) {
        infoPopUpFragment = InfoPopUpFragment.newInstance(texts)
        infoPopUpFragment!!.show(supportFragmentManager, InfoPopUpFragment.TAG)
    }


    /**
     * if visible fragment  = JobListFragment implement double click to exit
     * else Show current fragment from back stack and manipulate views accordingly
     */
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


    /**
     * Get currently visible fragment in supportfragment Manager
     */
    private fun getVisibleFragment(): Fragment? {
        val fragmentManager = this@MainActivity.supportFragmentManager
        val fragments = fragmentManager.fragments
        for (i in fragments.size downTo 1) {
            if (fragments.get(i - 1) != null && fragments.get(i - 1).isVisible)
                return fragments.get(i - 1)
        }
        return null
    }


    // To check user inactivity
    override fun onPause() {
        super.onPause()

        val activityManager = applicationContext
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        activityManager.moveTaskToFront(taskId, 0)
    }

    private val disconnectHandler = Handler(Handler.Callback {
        true
    })

    private val warningHandler = Handler(Handler.Callback {
        true
    })

    private val disconnectCallback = Runnable {
        openHomeScreen()
        forgetPopUpFragment?.dismiss()
    }

    private val warningCallback = Runnable {
        //        openPopUpInfo(resources.getString(R.string.inactive_msg))
        forgetPopUpFragment.show(fragmentManager, "")
    }

    private fun resetDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        warningHandler.removeCallbacks(warningCallback)
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT)
        warningHandler.postDelayed(warningCallback, WARNING_TIMEOUT)
    }

    override fun onUserInteraction() {
        resetDisconnectTimer()
    }

    public override fun onResume() {
        super.onResume()
        resetDisconnectTimer()
    }

    public override fun onStop() {
        super.onStop()
        stopDisconnectTimer()
    }

    private fun stopDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        warningHandler.removeCallbacks(warningCallback)
    }

}