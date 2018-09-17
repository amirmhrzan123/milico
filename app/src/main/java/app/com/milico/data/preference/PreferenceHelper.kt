package app.com.milico.data.preference

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferenceHelper constructor(
        context: Context): IPreferenceHelper{
    override fun setDeviceId(deviceId: String) {
        prefs.deviceId = deviceId
    }

    override fun getDeviceId(): String = prefs.deviceId


    fun defaultPrefs(context: Context): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)
    val prefs = defaultPrefs(context)


    companion object Consts{

        private const val API_KEY = "Api_Key"
        private const val PREF_KEY_IS_USER_LOGGED_IN = "login"
        private const val PREF_KEY_PIN = "pinKey"
        private const val PREF_COVER_IMAGE = "coverImage"
        private const val PREF_APP_LOGO = "appLogo"
        private const val PREF_CLUB_LOGO =  "clubLogo"
        private const val PREF_IS_FIRST_TIME = "isFirstTime"
        private const val PREF_APP_INFO = "appInfo"
        private const val PREF_DEVICE_ID = "deviceId"


    }

    override fun getAppInfo(): String = prefs.appInfo

    override fun setAppInfo(info: String) {
        prefs.appInfo = info
    }


    override fun setPinKey(key: String) {
        prefs.pinKey = key
    }

    override fun pinKey(): String = prefs.pinKey


    override fun isLogIn(): Boolean? = prefs.isLoggedIn

    override fun setLogin(login: Boolean) {
        prefs.isLoggedIn = login
    }

    override fun isFirstTime(): Boolean? = prefs.isFirstTime

    override fun setFirstTime(fistTime: Boolean) {
        prefs.isFirstTime = fistTime
    }

    override fun getCoverImage(): String = prefs.coverImage

    override fun setCoverImage(url: String) {
        prefs.coverImage = url
    }

    override fun getAppLog(): String = prefs.appImage

    override fun setAppLog(url: String) {
        prefs.appImage = url
    }

    override fun getClubLogo(): String = prefs.clubLogo

    override fun setClubLog(url: String) {
        prefs.clubLogo = url
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

    private var SharedPreferences.pinKey
        get() = getString(PREF_KEY_PIN, "")
        set(value) {
            putValue(PREF_KEY_PIN, value)
        }


    private var SharedPreferences.isFirstTime
        get() = getBoolean(PREF_IS_FIRST_TIME, false)
        set(value) {
            putValue(PREF_IS_FIRST_TIME, value)
        }

    private var SharedPreferences.coverImage
        get() = getString(PREF_COVER_IMAGE, "")
        set(value) {
            putValue(PREF_COVER_IMAGE, value)
        }

    private var SharedPreferences.appImage
        get() = getString(PREF_APP_LOGO, "")
        set(value) {
            putValue(PREF_APP_LOGO, value)
        }

    private var SharedPreferences.clubLogo
        get() = getString(PREF_CLUB_LOGO, "")
        set(value) {
            putValue(PREF_CLUB_LOGO, value)
        }

    private var SharedPreferences.appInfo
        get() = getString(PREF_APP_INFO, "")
        set(value) {
            putValue(PREF_APP_INFO, value)
        }

    private var SharedPreferences.deviceId
        get() = getString(PREF_DEVICE_ID, "")
        set(value) {
            putValue(PREF_DEVICE_ID, value)
        }

}