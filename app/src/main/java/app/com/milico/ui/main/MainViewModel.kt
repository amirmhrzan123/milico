package app.com.milico.ui.main

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import app.com.milico.base.BaseViewModel
import app.com.milico.data.local.json.JsonReader
import app.com.milico.data.repository.AppDataManager
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.util.SchedulerProvider

class MainViewModel constructor(
        resources: Resources,
        private val schedulers: SchedulerProvider,
        private val jsonReader: JsonReader,
        private val dataManager: AppDataManager):BaseViewModel(resources) {


    val infoClicked = SingleLiveEvent<String>()
    val isFirstTime = ObservableBoolean(false)
    val clubLogo = ObservableField<String>("")
    val checkOutEvent = SingleLiveEvent<Void>()
    val buttonClickEvent = SingleLiveEvent<Int>()
    val confirmClickEvent = SingleLiveEvent<String>()


    //for redeemModel
    var x:Int = 0
    var y:Int = 0

    val dashBoardModel = ObservableField<DashBoardModel.Data>()
    val giftsCardCount = ObservableField<Int>()
    val price = ObservableField<String>()
    val editable = ObservableBoolean(false)
    var quantity = ObservableField<String>()





    fun getGiftsCards(){
        val jsonModel = jsonReader.getModel("")
        Log.d("totalloyaly",jsonModel.totalLoyalty.toString())
    }


    //after editing all the giftcards quantity and price
    fun onCheckOutClicked(){ checkOutEvent.call() }

    fun onButtonClicked(price:Int){ buttonClickEvent.value = price }

    fun onConfirmClicked(){ confirmClickEvent.call() }


    fun onInfoClicked(){ infoClicked.value = dataManager.getAppInfo() }

    fun setFirstTime(){
        isFirstTime.set(true)
        clubLogo.set(dataManager.getClubLogo())
    }



    //for redeem ViewModel
    fun setGiftsCards(redeemModel: DashBoardModel.Data){
        //dataModel = redeemModel
        dashBoardModel.set(redeemModel)
    }

  /*  fun setDataModels(dataModels: DashBoardModel.Data){
        dataModel = dataModels
        dashBoardModel.set(dataModel)
    }

    fun getDataModels():DashBoardModel.Data{
        return dataModel
    }*/



    fun setXYvalue(xvalue:Int,yvalue:Int){
        x = xvalue
        y = yvalue
    }
    fun getXvalue():Int = x

    fun getYvalue():Int = y

    //edit price in dialog and enable the edit text if other is clicked
    fun setPriceForEdit(value:String){

        //if other is selected
        if(value.equals("1000")){
            editable.set(true)
            price.set("\$ Other")
        }else{
            editable.set(false)
            price.set("\$ $value")
        }
    }

    //on add click
    fun onAddClicked(){

    }

    //on minus click
    fun onMinusClicked(){


    }


    fun setGiftsCardCount(count:Int){
        giftsCardCount.set(count)
    }

    fun setGiftsRequestModel(requestModel: DashBoardModel.GiftsCardRequestModel){

    }


}