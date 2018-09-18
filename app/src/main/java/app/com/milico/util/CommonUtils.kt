package app.com.milico.util

import android.os.Build
import android.text.TextUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


const val FORMAT_DAY_MONTH_YEAR: String = "dd MMMM yyyy"
const val FORMAT_FULL_DATE: String = "yyyy-MM-dd HH:mm:ss"




fun getTimeZone():String = TimeZone.getDefault().id


fun getDeviceName(): String? {
    val manufacturer = Build.MANUFACTURER
    val model = Build.MODEL
    return if (model.startsWith(manufacturer)) {
        capitalize(model)
    } else capitalize(manufacturer) + " " + model
}

private fun capitalize(str: String): String? {
    if (TextUtils.isEmpty(str)) {
        return str
    }
    val arr = str.toCharArray()
    var capitalizeNext = true
    var phrase = ""
    for (c in arr) {
        if (capitalizeNext && Character.isLetter(c)) {
            phrase += Character.toUpperCase(c)
            capitalizeNext = false
            continue
        } else if (Character.isWhitespace(c)) {
            capitalizeNext = true
        }
        phrase += c
    }
    return phrase
}

fun getOSVersion() = android.os.Build.VERSION.RELEASE

fun convertDateToString(string: String, sourceFormat: String = FORMAT_FULL_DATE, resultFormat: String = FORMAT_DAY_MONTH_YEAR): String {
    val sdf = SimpleDateFormat(sourceFormat, Locale.getDefault())
    return try {
        val date = sdf.parse(string)
        convertDateToString(date, resultFormat)
    } catch (e: ParseException) {
        e.printStackTrace()
        ""
    }
}

fun convertDateToString(date: Date?, format: String = FORMAT_DAY_MONTH_YEAR): String {
    return if (date != null) {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        dateFormat.format(date)
    } else {
        ""
    }
}




