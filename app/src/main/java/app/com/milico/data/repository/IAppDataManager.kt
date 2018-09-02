package app.com.milico.data.repository


import app.com.milico.data.local.dbHelper.IDbHelper
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService

interface IAppDataManager: IApiService, IPreferenceHelper, IDbHelper {
}