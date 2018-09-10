package app.com.milico.data.repository


import app.com.milico.base.BaseResponse
import app.com.milico.data.local.dbHelper.IDbHelper
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService
import app.com.milico.ui.splash.RegisterModel
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class AppDataManager(private val apiService: IApiService,
                     private val iPreferenceHelper: IPreferenceHelper,
                     private val iDbHelper: IDbHelper,
                     private val compositeDisposable: CompositeDisposable,
                     private val gson: Gson): IAppDataManager {


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