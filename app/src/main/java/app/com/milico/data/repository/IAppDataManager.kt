package np.com.amir.apptest.data.repository

import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService
import np.com.amir.apptest.data.local.dbHelper.IDbHelper

interface IAppDataManager: IApiService, IPreferenceHelper,IDbHelper {
}