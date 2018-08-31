package app.com.milico.ui.splash

import android.arch.lifecycle.Observer
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivitySplashBinding
import org.koin.android.ext.android.inject

class SplashActivity: BaseActivity<ActivitySplashBinding>() {

    private val splashViewModel: SplashViewModel by inject()

    override fun getLayout(): Int = R.layout.activity_splash

    override fun initBinder() {
        dataBinding.viewModel = splashViewModel.apply {
            isLogIn.observe(this@SplashActivity, Observer {

               /* if(it!!){

                }else{
                    isUserLoggedIn()
                }*/
            })
        }

    }
}