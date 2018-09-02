package app.com.milico.data.preference

import android.content.Context
import android.content.SharedPreferences
import android.icu.lang.UCharacter
import android.preference.PreferenceManager

class PreferenceHelper constructor(
        context: Context): IPreferenceHelper{




    fun defaultPrefs(context: Context): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)
    val prefs = defaultPrefs(context)


    companion object Consts{

        private const val API_KEY = "Api_Key"
        private const val PREF_KEY_IS_USER_LOGGED_IN = "login"


    }



    override fun isLogIn(): Boolean? = prefs.isLoggedIn

    override fun setLogin(login: Boolean) {
        prefs.isLoggedIn = login
    }







    private fun SharedPreferences.putValue(key: String, value: Any?) {
        when (value) {
            is String -> edit().putString(key, value).apply()
            is Boolean -> edit().putBoolean(key, value).apply()
            is Int -> edit().putInt(key, value).apply()
            is Float -> edit().putFloat(key, value).apply()
            else -> UnsupportedOperationException("Not yet implemented.")
        }
    }

    private var SharedPreferences.isLoggedIn
        get() = getBoolean(PREF_KEY_IS_USER_LOGGED_IN, false)
        set(value) {
            putValue(PREF_KEY_IS_USER_LOGGED_IN, value)
        }
}