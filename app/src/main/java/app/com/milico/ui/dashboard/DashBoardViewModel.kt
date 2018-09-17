package app.com.milico.ui.dashboard

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class DashBoardViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager):BaseViewModel(resources) {

    val isButtonEnabled = ObservableBoolean(false)

    val membershipType = ObservableField<String>("")

    val userEmail = ObservableField<String>("")

    val expiryDate = ObservableField<String>("")

    val loyaltyValue = ObservableField<String>("")

    val loyaltyPointsAvailable = ObservableField<String>("")

    val userName = ObservableField<String>("")

    val redeemClickEvent = SingleLiveEvent<Void>()


    fun onRedeemClicked(){
        redeemClickEvent.call()
    }

    fun setFields(name:String,membershipTypes:String,userEmails:String,expiryDates:String,loyaltyValues:String,loyaltyPointAvailables:String){
        userName.set(name)
        membershipType.set("MEMBERSHIP STATUS: $membershipTypes")
        userEmail.set("EMAIL: $userEmails")
        expiryDate.set("MEMBERSHIP EXPIRY: $expiryDates")
        loyaltyValue.set("\$ $loyaltyValues")
        loyaltyPointsAvailable.set("$loyaltyPointAvailables POINTS AVAILABLE")
    }


}