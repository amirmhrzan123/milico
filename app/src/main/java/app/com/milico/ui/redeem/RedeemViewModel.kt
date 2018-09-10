package app.com.milico.ui.redeem

import android.content.res.Resources
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import app.com.milico.base.BaseViewModel
import app.com.milico.data.local.json.JsonModel
import app.com.milico.data.local.json.JsonReader
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent
import com.google.gson.Gson

class RedeemViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager,
        private val jsonReader: JsonReader,
        private val gson: Gson
        ):BaseViewModel(resources) {

        val listGiftsCards = ObservableField<JsonModel>()
        val itemClickEvent = SingleLiveEvent<Int>()

        fun getGiftsCards(){
                val jsonModel = jsonReader.getModel("")
                listGiftsCards.set(jsonModel)
                Log.d("totalloyaly",jsonModel.totalLoyalty.toString())
        }

        fun onItemClicked(position:Int,id:String,view: View){
              itemClickEvent.value = position
        }
}
