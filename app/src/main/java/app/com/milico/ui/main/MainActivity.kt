package app.com.milico.ui.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import app.com.milico.R
import app.com.milico.base.BaseActivity
import app.com.milico.databinding.ActivityMainBinding
import app.com.milico.ui.homeScreen.HomeScreenFragment
import app.com.milico.ui.pin.EnterPinFragment
import app.com.milico.ui.popUpView.InfoPopUpFragment
import app.com.milico.util.extensions.replaceFragmentInActivity
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject

class MainActivity: BaseActivity<ActivityMainBinding>(),IFragmentListener {

    val mainViewModel: MainViewModel by inject()

    private var infoPopUpFragment: InfoPopUpFragment?=null



    companion object {
        fun start(context: Context){
            context.startActivity<MainActivity>()
        }
    }

    override fun openHomeScreen() {
        replaceFragmentInActivity(HomeScreenFragment.newInstance(),R.id.fl_container,HomeScreenFragment.TAG)
    }

    override fun openPinKeyScreen() {
        replaceFragmentInActivity(EnterPinFragment.newInstance(),R.id.fl_container,EnterPinFragment.TAG)
    }

    override fun openForgotPin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayout(): Int = R.layout.activity_main

    override fun initBinder() {
        dataBinding.viewModel = mainViewModel.apply {
            infoClicked.observe(this@MainActivity, Observer {
                it?.let {
                    openPopUpInfo(it)
                }
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openHomeScreen()



    }

    fun openPopUpInfo(texts:String){
        infoPopUpFragment= InfoPopUpFragment.newInstance(texts)
        infoPopUpFragment!!.show(supportFragmentManager,InfoPopUpFragment.TAG)
    }


}