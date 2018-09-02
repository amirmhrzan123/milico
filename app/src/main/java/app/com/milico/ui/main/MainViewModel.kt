package app.com.milico.ui.main

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class MainViewModel constructor(
        resources: Resources,
       private val dataManager: AppDataManager):BaseViewModel(resources) {



}