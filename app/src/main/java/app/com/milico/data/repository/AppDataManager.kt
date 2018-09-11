package app.com.milico.data.repository


import app.com.milico.base.BaseResponse
import app.com.milico.data.local.dbHelper.IDbHelper
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService
import app.com.milico.ui.homeScreen.HomeScreenModel
import app.com.milico.ui.splash.RegisterModel
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class AppDataManager(private val apiService: IApiService,
                     private val iPreferenceHelper: IPreferenceHelper,
                     private val iDbHelper: IDbHelper,
                     private val compositeDisposable: CompositeDisposable,
                     private val gson: Gson) : IAppDataManager {


    override fun getAppInfo(): String = iPreferenceHelper.getAppInfo()

    override fun setAppInfo(info: String) {
        iPreferenceHelper.setAppInfo(info)
    }


    override fun isFirstTime(): Boolean? = iPreferenceHelper.isFirstTime()

    override fun setFirstTime(fistTime: Boolean) {
        iPreferenceHelper.setFirstTime(fistTime)
    }

    override fun getCoverImage(): String = iPreferenceHelper.getCoverImage()

    override fun setCoverImage(url: String) {
        iPreferenceHelper.setCoverImage(url)
    }

    override fun getAppLog(): String = iPreferenceHelper.getAppLog()

    override fun setAppLog(url: String) {
        iPreferenceHelper.setAppLog(url)
    }

    override fun getClubLogo(): String = iPreferenceHelper.getClubLogo()

    override fun setClubLog(url: String) {
        iPreferenceHelper.setClubLog(url)
    }

    override fun getLandingInfo(homeScreenRequestModel: HomeScreenModel.HomeScreenRequestModel): Observable<BaseResponse<HomeScreenModel.Data>> {
        return apiService.getLandingInfo(homeScreenRequestModel)
    }


    override fun registerDevice(deviceRegisterRequestModel: RegisterModel.DeviceRegisterRequestModel): Observable<BaseResponse<Any>> {
        return apiService.registerDevice(deviceRegisterRequestModel)
    }

    override fun setPinKey(key: String) {
        iPreferenceHelper.setPinKey(key)
    }

    override fun pinKey(): String = iPreferenceHelper.pinKey()


    override fun isLogIn(): Boolean? =
            iPreferenceHelper.isLogIn()

    override fun setLogin(login: Boolean) {
        iPreferenceHelper.setLogin(login)
    }


}