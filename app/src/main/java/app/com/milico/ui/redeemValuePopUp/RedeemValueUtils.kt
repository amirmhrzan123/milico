package app.com.milico.ui.redeemValuePopUp

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.TextView
import app.com.milico.R
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.util.convertPointToValue
import com.google.gson.Gson

object RedeemValueUtils {


    //redeem button is true when redeem all is clicked
    @BindingAdapter("dataModel","amount","isAllRedeem")
    @JvmStatic
    fun validateButtons(button: Button,dataModel:DashBoardModel.Data,amount: Double,isAllRedeem:Boolean){
        val gson = Gson()
        with(button){

            isEnabled = when {
                dataModel.club?.floatBalance!! < amount -> {
                    setBackgroundColor(ContextCompat.getColor(context,R.color.textView_background))
                    false
                }
                convertPointToValue(dataModel.cardInfo?.totalRemainingPoints!!,dataModel.cardInfo.ratio)<amount -> {
                    setBackgroundColor(ContextCompat.getColor(context,R.color.textView_background))
                    false
                }
                else -> {
                    if(isAllRedeem){
                        setBackgroundColor(ContextCompat.getColor(context,R.color.not_ok_keypad))
                    }else{
                        setBackgroundColor(ContextCompat.getColor(context,R.color.redeem_button))

                    }
                    true
                }
            }
        }
    }

    @BindingAdapter("values")
    @JvmStatic
    fun setLoyaltyValueText(textView:TextView,dataModel: DashBoardModel.Data){
        with(textView){
            text = "\$"+ convertPointToValue(dataModel.cardInfo?.totalRemainingPoints!!,dataModel.cardInfo.ratio).toString()
        }
    }


}