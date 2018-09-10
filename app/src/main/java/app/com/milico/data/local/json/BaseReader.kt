package app.com.milico.data.local.json

import com.google.gson.Gson

abstract class BaseReader:JsonReader {
    private val gson = Gson()
    private val json_file = ".json"
    private val loyaltyGifts = "loyalty_gifts"

    abstract fun readJsonFile(jsonFile: String): String

    override fun getModel(name: String): JsonModel = gson.fromJson<JsonModel>(readJsonFile(loyaltyGifts +json_file), JsonModel::class.java)


}