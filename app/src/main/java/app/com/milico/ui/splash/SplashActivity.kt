package app.com.milico.ui.splash

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.provider.Settings
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivitySplashBinding
import app.com.milico.ui.main.MainActivity
import app.com.milico.util.getDeviceName
import app.com.milico.util.getOSVersion
import app.com.milico.util.getTimeZone
import org.koin.android.ext.android.inject
import java.util.*

class SplashActivity: BaseActivity<ActivitySplashBinding>() {

    private val splashViewModel: SplashViewModel by inject()

    override fun getLayout(): Int = R.layout.activity_splash

    override fun initBinder() {


        dataBinding.viewModel = splashViewModel.apply {

            setPinKey("1234")
            registerDevice(RegisterModel.DeviceRegisterRequestModel(Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID),
                                                        getDeviceName()!!, getOSVersion(), getTimeZone(), Locale.getDefault().getLanguage()))

            registerEvent.observe(this@SplashActivity, Observer {
                MainActivity.start(this@SplashActivity)
                finish()
            })

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinder()
    }


}