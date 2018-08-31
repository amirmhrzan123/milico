package np.com.amir.apptest.data.repository

import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import np.com.amir.apptest.data.local.dbHelper.IDbHelper

class AppDataManager(private val apiService: IApiService,
                     private val iPreferenceHelper: IPreferenceHelper,
                     private val iDbHelper: IDbHelper,
                     private val compositeDisposable: CompositeDisposable,
                     private val gson: Gson):IAppDataManager {



    override fun isLogIn(): Boolean? =
        iPreferenceHelper.isLogIn()

    override fun setLogin(login: Boolean) {
        iPreferenceHelper.setLogin(login)
    }


}