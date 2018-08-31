package app.com.milico.ui.pin

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import np.com.amir.apptest.data.repository.AppDataManager

class EnterPinViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {
}