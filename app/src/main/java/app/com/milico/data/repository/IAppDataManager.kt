package app.com.milico.data.repository


import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.remote.IApiService

interface IAppDataManager: IApiService, IPreferenceHelper  {
}