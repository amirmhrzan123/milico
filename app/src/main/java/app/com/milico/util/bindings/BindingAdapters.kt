package app.com.milico.util.bindings

import android.databinding.BindingAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import app.com.milico.util.extensions.setFirstLetterCapitalisedText


object BindingAdapters {
    @BindingAdapter("enableButton")
    @JvmStatic
    fun enableButtonEvent(button: Button, enableButton: Boolean) {
        with(button) {
            isEnabled = enableButton
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
