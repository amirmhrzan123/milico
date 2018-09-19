package app.com.milico.ui.editQuantityDialog

import android.content.res.Resources
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel

class EditQuantityViewModel constructor(resources: Resources)
    :BaseViewModel(resources){

    var quantityField = ObservableField<String>()

    var totalQuantity : Int = 0

    fun onAddClicked(){
        if(quantityField.get()==null){
            totalQuantity = 0
        }else{
            totalQuantity = quantityField.get().toString().trim().toInt()

        }
        quantityField.set((totalQuantity+1).toString())

    }

    fun onSubtractClicked(){
        if(quantityField.get()==null){
            totalQuantity = 0
        }else{
            totalQuantity = quantityField.get().toString().trim().toInt()

        }
        if(totalQuantity>0){
            quantityField.set((totalQuantity-1).toString())
        }else{
            quantityField.set(0.toString())
        }
    }


}