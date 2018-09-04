package app.com.milico.ui.main

import android.content.res.Resources
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class MainViewModel constructor(
        resources: Resources,
       private val dataManager: AppDataManager):BaseViewModel(resources) {

    val infoClicked = SingleLiveEvent<String>()

    val url = ObservableField<String>()


    fun setUrl(urls:String){
        url.set(urls)
    }

    fun onInfoClicked(){
        infoClicked.value = ""
    }


}