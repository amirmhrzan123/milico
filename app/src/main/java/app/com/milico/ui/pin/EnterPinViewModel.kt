package app.com.milico.ui.pin

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent
import rx.Single

class EnterPinViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {

    val onePressedEvent = SingleLiveEvent<Void>()
    val twoPressedEvent = SingleLiveEvent<Void>()
    val threePressedEvent = SingleLiveEvent<Void>()
    val fourPressedEvent = SingleLiveEvent<Void>()
    val fivePressedEvent = SingleLiveEvent<Void>()
    val sixPressedEvent = SingleLiveEvent<Void>()
    val sevenPressedEvent = SingleLiveEvent<Void>()
    val eightPressedEvent = SingleLiveEvent<Void>()
    val ninePressedEvent = SingleLiveEvent<Void>()
    val zeroPressedEvent = SingleLiveEvent<Void>()
    val okPressedEvent = SingleLiveEvent<Void>()
    val backPressedEvent = SingleLiveEvent<Void>()


    fun on1Pressed(){
        onePressedEvent.call()
    }

    fun on2Pressed(){
        twoPressedEvent.call()
    }

    fun on3Pressed(){
        threePressedEvent.call()
    }

    fun on4Pressed(){
        fourPressedEvent.call()
    }

    fun on5Pressed(){
        fivePressedEvent.call()
    }

    fun on6Pressed(){
        sixPressedEvent.call()
    }

    fun on7Pressed(){
        sevenPressedEvent.call()
    }

    fun on8Pressed(){
        eightPressedEvent.call()
    }

    fun on9Pressed() {
        ninePressedEvent.call()
    }

    fun on0Pressed(){
        zeroPressedEvent.call()
    }

    fun onOkPressed(){
        okPressedEvent.call()
    }

    fun onBackPressed(){
        onePressedEvent.call()
    }
}