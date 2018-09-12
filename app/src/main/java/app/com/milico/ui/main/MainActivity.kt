package app.com.milico.ui.main

import android.app.ActivityManager
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivityMainBinding
import app.com.milico.ui.dashboard.DashBoardFragment
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.ui.homeScreen.HomeScreenFragment
import app.com.milico.ui.pin.EnterPinFragment
import app.com.milico.ui.popUpView.InfoPopUpFragment
import app.com.milico.ui.redeem.RedeemFragment
import app.com.milico.ui.review.ReviewFragment
import app.com.milico.util.extensions.addFragmentToActivity
import app.com.milico.util.extensions.replaceFragmentInActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding>(), IFragmentListener {
    override fun openReview() {
        addFragmentToActivity(ReviewFragment.getInstance(), R.id.fl_container, RedeemFragment.TAG)
    }


    val mainViewModel: MainViewModel by inject()

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

    override fun openDashBoard(dashboardModel: DashBoardModel) {
        replaceFragmentInActivity(DashBoardFragment.newInstance(dashboardModel), R.id.fl_container, DashBoardFragment.TAG)
    }

    override fun openRedeemPage() {
        replaceFragmentInActivity(RedeemFragment.newInstance(), R.id.fl_container, RedeemFragment.TAG, addToBackStack = true)
        addFragmentToActivity(RedeemFragment.newInstance(), R.id.fl_container, RedeemFragment.TAG)
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
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinder()
        openHomeScreen()
    }

    private fun openPopUpInfo(texts: String) {
        infoPopUpFragment = InfoPopUpFragment.newInstance(texts)
        infoPopUpFragment!!.show(supportFragmentManager, InfoPopUpFragment.TAG)
    }


    override fun onBackPressed() {
        //do nothing
    }

    // To check user inactivity
    override fun onPause() {
        super.onPause()

        val activityManager = applicationContext
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        activityManager.moveTaskToFront(taskId, 0)
    }

    private val disconnectHandler = Handler(Handler.Callback {
        // todo
        true
    })

    private val disconnectCallback = Runnable {
        toast("User inactive")
        openPinKeyScreen()
    }

    private fun resetDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT)
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
    }

}