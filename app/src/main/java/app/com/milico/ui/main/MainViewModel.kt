package app.com.milico.ui.main

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import app.com.milico.base.BaseViewModel
import app.com.milico.data.local.json.JsonModel
import app.com.milico.data.local.json.JsonReader
import app.com.milico.data.repository.AppDataManager
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

    val listGiftsCards = ObservableField<JsonModel>()
    val itemClickEvent = SingleLiveEvent<Int>()
    val checkOutEvent = SingleLiveEvent<Void>()
    val buttonClickEvent = SingleLiveEvent<Int>()
    val confirmClickEvent = SingleLiveEvent<String>()
    var x:Int = 0
    var y:Int = 0


    fun getGiftsCards(){
        val jsonModel = jsonReader.getModel("")
        listGiftsCards.set(jsonModel)
        Log.d("totalloyaly",jsonModel.totalLoyalty.toString())
    }

    fun setXYvalue(xvalue:Int,yvalue:Int){
        x = xvalue
        y = yvalue
    }
    fun getXvalue():Int = x

    fun getYvalue():Int = y

    fun onItemClicked(position:Int,id:String,view: View){
        itemClickEvent.value = position
    }

    //after editing all the giftcards quantity and price
    fun onCheckOutClicked(){
        checkOutEvent.call()
    }

    //
    fun onButtonClicked(price:Int){
        buttonClickEvent.value = price
    }

    fun onConfirmClicked(){
        confirmClickEvent.call()
    }


    fun onInfoClicked(){
        infoClicked.value = dataManager.getAppInfo()
    }
    fun setFirstTime(){
        isFirstTime.set(true)
        clubLogo.set(dataManager.getClubLogo())
    }





}