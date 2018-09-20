package app.com.milico.ui.main

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel
import app.com.milico.data.local.json.JsonReader
import app.com.milico.data.repository.AppDataManager
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.ui.editQuantityDialog.EditQuantityPriceModel
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.util.SchedulerProvider

class MainViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager) : BaseViewModel(resources) {

    val infoClicked = SingleLiveEvent<String>()
    val isFirstTime = ObservableBoolean(false)
    val clubLogo = ObservableField<String>("")
    val checkOutEvent = SingleLiveEvent<Void>()
    val goToHome = SingleLiveEvent<Boolean>()

    val dashBoardModel = ObservableField<DashBoardModel.Data>()
    val giftsCardCount = ObservableField<Int>()
    var dataModel = DashBoardModel.Data()
    val confirmClickEvent = SingleLiveEvent<EditQuantityPriceModel.EditModel>()

    var position:Int = 0





    //after editing all the giftcards quantity and price
    fun onCheckOutClicked() {
        checkOutEvent.call()
    }




    fun onInfoClicked() {
        infoClicked.value = dataManager.getAppInfo()
    }

    fun onHomeClicked() {
        goToHome.value = true
    }

    fun setFirstTime() {
        isFirstTime.set(true)
        clubLogo.set(dataManager.getClubLogo())
    }


    fun setDataModels(mdataModel: DashBoardModel.Data){
        mdataModel.cardInfo?.totalRedeemPoints = 0.0
        mdataModel.cardInfo?.totalRemainingPoints = mdataModel.cardInfo!!.loyaltyPoint
        mdataModel.cardInfo.ratio = mdataModel.cardInfo.loyaltyPoint/mdataModel.cardInfo.loyaltyValue
        dataModel = mdataModel
        dashBoardModel.set(dataModel)
    }





    fun setGiftsCardCount(count: Int) {
            giftsCardCount.set(count)
        }

    fun setGiftsRequestModel(requestModel: DashBoardModel.GiftsCardRequestModel) {}


    fun onConfirmClicked(editModel:EditQuantityPriceModel.EditModel){
        confirmClickEvent.value = editModel
    }

}