package app.com.milico.ui.homeScreen

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class HomeScreenViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {

    var openEnterPin = SingleLiveEvent<Void>()


    fun openEnterPin(){
        openEnterPin.call()
    }

}