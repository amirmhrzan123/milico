package app.com.milico.ui.pin

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.util.Log
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class EnterPinViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {


    val okPressedEvent = SingleLiveEvent<Void>()
    val forgottenPasswordEvent = SingleLiveEvent<Void>()

    private var keys : String =""

    val image1 =  ObservableBoolean(false)
    val image2 = ObservableBoolean(false)
    val image3 = ObservableBoolean(false)
    val image4 = ObservableBoolean(false)




    fun on1Pressed(){
        checkLength("1")
    }

    fun on2Pressed(){
        checkLength("2")

    }

    fun on3Pressed(){
        checkLength("3")

    }

    fun on4Pressed(){
        checkLength("4")

    }

    fun on5Pressed(){
        checkLength("5")

    }

    fun on6Pressed(){
        checkLength("6")

    }

    fun on7Pressed(){
        checkLength("7")

    }

    fun on8Pressed(){
        checkLength("8")

    }

    fun on9Pressed() {
        checkLength("9")

    }

    fun on0Pressed(){
        checkLength("0")
    }

    fun onOkPressed(){
        okPressedEvent.call()
    }



    fun onBackPressed(){

        if(keys.length>0){
            keys = keys.substring(0,keys.length-1)
            Log.d("string",keys)

        }
        setResetImages()

    }


    fun onForgotPasswordPressed(){
        forgottenPasswordEvent.call()
    }

    fun checkLength(number: String){
        if(keys.length <4){
            keys += number
            Log.d("string",keys)
        }
        setResetImages()

    }

    fun setResetImages(){
        when(keys.length){
            0->{
                image1.set(false)
                image2.set(false)
                image3.set(false)
                image4.set(false)
            }
            1->{
                image1.set(true)
                image2.set(false)
                image3.set(false)
                image4.set(false)
            }
            2->{
                image1.set(true)
                image2.set(true)
                image3.set(false)
                image4.set(false)
            }
            3->{
                image1.set(true)
                image2.set(true)
                image3.set(true)
                image4.set(false)
            }
            4->{
                image1.set(true)
                image2.set(true)
                image3.set(true)
                image4.set(true)
            }
        }

    }
}