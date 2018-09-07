package app.com.milico.ui.redeem

import android.content.res.Resources
import android.databinding.ObservableField
import android.util.Log
import app.com.milico.base.BaseViewModel
import app.com.milico.data.local.json.JsonModel
import app.com.milico.data.local.json.JsonReader
import app.com.milico.data.repository.AppDataManager
import com.google.gson.Gson

class RedeemViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager,
        private val jsonReader: JsonReader,
        private val gson: Gson
        ):BaseViewModel(resources) {

        val listGiftsCards = ObservableField<JsonModel>()

        fun getGiftsCards(){
                val jsonModel = jsonReader.getModel("")
                listGiftsCards.set(jsonModel)
                Log.d("totalloyaly",jsonModel.totalLoyalty.toString())
        }
}
