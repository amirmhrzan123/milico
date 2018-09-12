package app.com.milico.ui.homeScreen

import android.content.res.Resources
import android.databinding.ObservableField
import android.util.Log
import app.com.milico.base.BaseResponse
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.StatusCode
import app.com.milico.util.bindings.SingleLiveEvent
import np.com.amir.apptest.util.SchedulerProvider

class HomeScreenViewModel constructor(
        resources: Resources,
        private val schedulers: SchedulerProvider,
        private val dataManager: AppDataManager): BaseViewModel(resources) {

    var openEnterPin = SingleLiveEvent<Void>()

    val errorEvent = SingleLiveEvent<String>()

    val coverImage = ObservableField<String>("")



    val appDetailsEvents = SingleLiveEvent<Void>()




    fun openEnterPin(){
        openEnterPin.call()
    }

    fun getAppDetails(deviceId:String){
        if(dataManager.isFirstTime()!!){
           // showProgressBar()
        }
        compositeDisposable.add(dataManager.getLandingInfo(HomeScreenModel.HomeScreenRequestModel(deviceId))
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe({
                    response: BaseResponse<HomeScreenModel.Data>?->
                    response?.apply{
                        when (status) {
                            StatusCode.SUCCESS -> {
                               // hideProgressBar()
                                dataManager.setFirstTime(true)
                                dataManager.setClubLog(results!!.clubLogo)
                                dataManager.setAppLog(results.appLogo)
                                dataManager.setCoverImage(results.coverImage[0])
                                dataManager.setAppInfo(results.appInformation)
                                coverImage.set(dataManager.getCoverImage())
                                Log.d("appInof",dataManager.getAppInfo())
                                appDetailsEvents.call()

                            }
                            else -> {
                                //hideProgressBar()
                                errorEvent.value = response.message
                            }
                        }
                    }
                },{
                    error->
                    handleError(error)

                }))

    }









}