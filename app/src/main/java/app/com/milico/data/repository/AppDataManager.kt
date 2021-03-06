package app.com.milico.data.repository


import app.com.milico.data.local.dbHelper.IDbHelper
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService
import app.com.milico.data.repository.IAppDataManager
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable

class AppDataManager(private val apiService: IApiService,
                     private val iPreferenceHelper: IPreferenceHelper,
                     private val iDbHelper: IDbHelper,
                     private val compositeDisposable: CompositeDisposable,
                     private val gson: Gson): IAppDataManager {



    override fun isLogIn(): Boolean? =
        iPreferenceHelper.isLogIn()

    override fun setLogin(login: Boolean) {
        iPreferenceHelper.setLogin(login)
    }


}