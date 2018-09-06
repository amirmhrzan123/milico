package app.com.milico.ui.splash

import android.arch.lifecycle.Observer
import android.os.Bundle
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivitySplashBinding
import app.com.milico.ui.main.MainActivity
import app.com.milico.ui.popUpView.ForgetPopUpFragment
import org.koin.android.ext.android.inject

class SplashActivity: BaseActivity<ActivitySplashBinding>() {

    private val splashViewModel: SplashViewModel by inject()
    private var forgetPopUpFragment: ForgetPopUpFragment?=null


    override fun getLayout(): Int = R.layout.activity_splash

    override fun initBinder() {


        dataBinding.viewModel = splashViewModel.apply {

            isUserLoggedIn()

            isLogIn.observe(this@SplashActivity, Observer {
                setPinKey("1234")
                MainActivity.start(this@SplashActivity)
                finish()
                val ft = fragmentManager?.beginTransaction()
                forgetPopUpFragment= ForgetPopUpFragment.newInstance()
                forgetPopUpFragment!!.show(ft, ForgetPopUpFragment.TAG)
               /* if(it!!){

                }else{
                    isUserLoggedIn()
                }*/
            })
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinder()
    }
}