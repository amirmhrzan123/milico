package app.com.milico.ui.main

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.util.SchedulerProvider

class MainViewModel constructor(
        resources: Resources,
        private val schedulers: SchedulerProvider,
        private val dataManager: AppDataManager):BaseViewModel(resources) {

    val infoClicked = SingleLiveEvent<String>()

    val isFirstTime = ObservableBoolean(false)

    val clubLogo = ObservableField<String>("")





    fun onInfoClicked(){
        infoClicked.value = dataManager.getAppInfo()
    }

    fun setFirstTime(){
        isFirstTime.set(true)
        clubLogo.set(dataManager.getClubLogo())
    }





}