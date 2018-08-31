package app.com.milico.ui.homeScreen

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.data.repository.AppDataManager

class HomeScreenViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {

    var openEnterPin = SingleLiveEvent<Void>()


    fun openEnterPin(){
        openEnterPin.call()
    }

}