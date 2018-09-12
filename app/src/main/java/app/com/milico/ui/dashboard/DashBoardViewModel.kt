package app.com.milico.ui.dashboard

import android.content.res.Resources
import android.databinding.ObservableBoolean
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class DashBoardViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager):BaseViewModel(resources) {

    val isButtonEnabled = ObservableBoolean(false)

    val redeemClickEvent = SingleLiveEvent<Void>()
    val pointsClickEvent = SingleLiveEvent<Void>()


    fun onRedeemClicked(){
        redeemClickEvent.call()
    }

    fun onPointsClicked(){
        pointsClickEvent.call()
    }


}