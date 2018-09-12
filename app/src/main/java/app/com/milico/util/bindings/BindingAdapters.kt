package app.com.milico.util.bindings

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import app.com.milico.util.extensions.setFirstLetterCapitalisedText


object BindingAdapters {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        with(imageView) {
            if (!TextUtils.isEmpty(url)) {


            } else {

            }
        }
    }


    @BindingAdapter("cursorPosition")
    @JvmStatic
    fun setCursorPosition(editText: EditText, string: String) {
        with(editText) {
            setSelection(string.length)
        }
    }

    @BindingAdapter("capitaliseFirstLetter")
    @JvmStatic
    fun setCapitaliseText(textView: TextView, string: String) {
        with(textView) {
            setFirstLetterCapitalisedText(string)
        }
    }
}
