package app.com.milico.data.local.json

import android.app.Application
import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class AndroidJsonReader(private val context: Context):BaseReader() {
    override fun readJsonFile(jsonFile: String): String {
        val buf = StringBuilder()
        val json = context.assets.open("json/" + jsonFile)
        BufferedReader(InputStreamReader(json, "UTF-8"))
                .use {
                    val list = it.lineSequence().toList()
                    buf.append(list.joinToString("\n"))
                }

        return buf.toString()    }
}