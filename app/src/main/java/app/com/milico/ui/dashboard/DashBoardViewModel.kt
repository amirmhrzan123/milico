package app.com.milico.ui.dashboard

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class DashBoardViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager):BaseViewModel(resources) {

    val redeemClickEvent = SingleLiveEvent<Void>()

    fun onRedeemClicked(){
        redeemClickEvent.call()
    }

}