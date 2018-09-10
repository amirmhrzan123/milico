package app.com.milico.data.local.json

interface JsonReader {

    fun getModel(name: String): JsonModel
}