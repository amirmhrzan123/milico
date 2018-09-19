package app.com.milico.ui.redeemValuePopUp

import android.content.res.Resources
import app.com.milico.base.BaseViewModel
import app.com.milico.util.bindings.SingleLiveEvent

class RedeemValueViewModel constructor(
        resources: Resources):BaseViewModel(resources) {

    val buttonClickEvent = SingleLiveEvent<Int>()
    var clubPointsAvailable: Double = 0.0
    var ratio : Double = 0.0
    var quantity:Int = 0

    fun onButtonClicked(price: Int) {
        buttonClickEvent.value = price
    }

}