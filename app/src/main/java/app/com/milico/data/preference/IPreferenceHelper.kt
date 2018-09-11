package app.com.milico.data.preference

interface IPreferenceHelper {

    fun isLogIn(): Boolean?

    fun setLogin(login: Boolean)

    fun setPinKey(key: String)

    fun pinKey():String

    fun isFirstTime(): Boolean?

    fun setFirstTime(fistTime: Boolean)

    fun getCoverImage():String

    fun setCoverImage(url:String)

    fun getAppLog(): String

    fun setAppLog(url:String)

    fun getClubLogo(): String

    fun setClubLog(url:String)

    fun getAppInfo():String

    fun setAppInfo(info:String)


}