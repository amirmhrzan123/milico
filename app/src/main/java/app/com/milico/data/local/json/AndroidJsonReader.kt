package app.com.milico.data.local.json

import android.app.Application
import java.io.BufferedReader
import java.io.InputStreamReader

class AndroidJsonReader(private val application:Application):BaseReader() {
    override fun readJsonFile(jsonFile: String): String {
        val buf = StringBuilder()
        val json = application.assets.open("json/" + jsonFile)
        BufferedReader(InputStreamReader(json, "UTF-8"))
                .use {
                    val list = it.lineSequence().toList()
                    buf.append(list.joinToString("\n"))
                }

        return buf.toString()    }
}