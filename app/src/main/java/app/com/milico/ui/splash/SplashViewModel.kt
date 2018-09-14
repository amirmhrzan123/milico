package app.com.milico.ui.splash

import android.content.res.Resources
import app.com.milico.base.BaseResponse
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.StatusCode
import app.com.milico.util.bindings.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import np.com.amir.apptest.util.SchedulerProvider

class SplashViewModel constructor(
        resources: Resources,
        private val schedulers: SchedulerProvider,
        private val dataManager: AppDataManager) : BaseViewModel(resources) {

    var isLogIn = SingleLiveEvent<Boolean>()

    val registerEvent = SingleLiveEvent<Void>()

    val notRegisterEvent = SingleLiveEvent<String>()

    fun isUserLoggedIn() {
        isLogIn.value = dataManager.isLogIn()
    }

    fun setPinKey(key: String) {
        dataManager.setPinKey(key)
    }

    fun registerDevice(deviceRegisterRequestModel: RegisterModel.DeviceRegisterRequestModel) {

        compositeDisposable.add(
                dataManager.registerDevice(deviceRegisterRequestModel)
                        .subscribeOn(schedulers.io())
                        .observeOn(schedulers.ui())
                        .subscribe({ t: BaseResponse<Any>? ->
                            t?.let {
                                registerEvent.call()
                            }
                        }, { error ->
                            handleError(error)
                        }))

    }
}