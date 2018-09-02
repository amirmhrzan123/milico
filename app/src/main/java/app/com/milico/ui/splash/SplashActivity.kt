package app.com.milico.ui.splash

import android.arch.lifecycle.Observer
import android.os.Bundle
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivitySplashBinding
import app.com.milico.ui.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity: BaseActivity<ActivitySplashBinding>() {

    private val splashViewModel: SplashViewModel by inject()

    override fun getLayout(): Int = R.layout.activity_splash

    override fun initBinder() {


        dataBinding.viewModel = splashViewModel.apply {

            isUserLoggedIn()
            isLogIn.observe(this@SplashActivity, Observer {

                MainActivity.start(this@SplashActivity)
                finish()
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