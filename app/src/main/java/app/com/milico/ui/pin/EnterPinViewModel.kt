package app.com.milico.ui.pin

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.util.Log
import app.com.milico.R
import app.com.milico.base.BaseViewModel
import app.com.milico.data.repository.AppDataManager
import app.com.milico.util.bindings.SingleLiveEvent

class EnterPinViewModel constructor(
        resources: Resources,
        private val dataManager: AppDataManager): BaseViewModel(resources) {


    val okPressedEvent = SingleLiveEvent<Void>()
    val forgottenPasswordEvent = SingleLiveEvent<Void>()
    var okenabled = ObservableBoolean(false)

    private var keys : String =""

    val image1 =  ObservableBoolean(false)
    val image2 = ObservableBoolean(false)
    val image3 = ObservableBoolean(false)
    val image4 = ObservableBoolean(false)






    fun enableDisableButton(enable:Boolean){
        okenabled.set(enable)
    }



    fun onOkPressed(){
        if(keys.equals("1234")){
            okPressedEvent.call()
        }else{
            showAlertDialog(R.string.incorrect_pin)
        }

    }



    fun onBackPressed(){

        if(keys.length>0){
            keys = keys.substring(0,keys.length-1)
            Log.d("string",keys)

        }
        enableDisableButton(false)

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
        if(keys.length>=4){
            enableDisableButton(true)

        }else{
            enableDisableButton(false)
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