package app.com.milico.ui.dashboard

import android.databinding.BindingAdapter
import android.widget.TextView

object DashBoardUtils{
    @BindingAdapter("membershipType")
    @JvmStatic
    fun setMemberShipType(textView: TextView, type: String) {
        with(textView){
           text = "MEMBERSHIP STATUS: $type"
        }
    }

    @BindingAdapter("userEmail")
    @JvmStatic
    fun setExpirydate(textView: TextView, email: String) {
        with(textView){
            text = "EMAIL: $email"
        }
    }

    @BindingAdapter("expiry")
    @JvmStatic
    fun setExpiry(textView: TextView, expiry: String) {
        with(textView){
            text = "MEMBERSHIP EXPIRY: $expiry"
        }
    }

    @BindingAdapter("loyaltyValue")
    @JvmStatic
    fun setLoyaltyValue(textView: TextView, loyaltyValue: Double) {
        with(textView){
            text = "\$ $loyaltyValue"
        }
    }

    @BindingAdapter("loyaltyPoint")
    @JvmStatic
    fun setLoyaltyPoint(textView: TextView, loyaltyPoint: Double) {
        with(textView){
            text = "$loyaltyPoint POINTS AVAILABLE"
        }
    }
}