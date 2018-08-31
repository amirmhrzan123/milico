package app.com.milico.ui.main

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.data.repository.AppDataManager

class MainViewModel constructor(
        resources: Resources,
       private val dataManager: AppDataManager):BaseViewModel(resources) {



}