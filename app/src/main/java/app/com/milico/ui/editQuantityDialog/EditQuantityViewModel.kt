package app.com.milico.ui.editQuantityDialog

import android.content.res.Resources
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import app.com.milico.base.BaseViewModel
import app.com.milico.util.bindings.SingleLiveEvent

class EditQuantityViewModel constructor(resources: Resources)
    :BaseViewModel(resources){

    var quantityField = ObservableField<String>("0")

    var totalQuantity : Int = 0

    val priceField = ObservableField<String>("0")

    var price : String ="0"

    private val editModel= EditQuantityPriceModel.EditModel()

    val confirmClickEvent = SingleLiveEvent<EditQuantityPriceModel.EditModel>()

    val editable = ObservableBoolean(false)



    fun onAddClicked(){
        totalQuantity = if(quantityField.get()==null){
            0
        }else{
            quantityField.get().toString().trim().toInt()

        }
        totalQuantity += 1
        quantityField.set((totalQuantity).toString())

    }

    fun onSubtractClicked(){
        totalQuantity = if(quantityField.get()==null){
            0
        }else{
            quantityField.get().toString().trim().toInt()
        }
        totalQuantity -= 1
        if(totalQuantity>0){
            quantityField.set((totalQuantity).toString())
        }else{
            quantityField.set(0.toString())
        }
    }

    fun onConfirmClicked(){
        editModel.quantity = totalQuantity
        price = priceField.get().toString()
        editModel.price = price.replace("$","").replace(" ","").toDouble()
        confirmClickEvent.value = editModel
    }


}