package app.com.milico.ui.splash

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class SplashViewModel constructor(
        resources: Resources,
        private val  dataManager: AppDataManager):BaseViewModel(resources) {

    var isLogIn = SingleLiveEvent<Boolean>()

    fun isUserLoggedIn(){
        isLogIn.value = dataManager.isLogIn()
    }

    fun setPinKey(key: String){
        dataManager.setPinKey(key)
    }



}