package app.com.milico.ui.pin

import android.databinding.BindingAdapter
import android.widget.ImageView
import app.com.milico.R.drawable.keypad_circle_one
import app.com.milico.R.drawable.keypad_circle_two

object EnterPinBindingUtils {
    @BindingAdapter("setReset")
    @JvmStatic
    fun setResetImageView(imageView: ImageView, setReset: Boolean) {
        with(imageView){
            if(setReset){
                setImageResource(keypad_circle_two)
            }else{
                setImageResource(keypad_circle_one)
            }
        }
    }


}