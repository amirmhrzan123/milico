package app.com.milico.util.extensions

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import app.com.milico.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import uk.co.chrisjenx.calligraphy.CalligraphyUtils
import java.math.BigDecimal

fun Context.showAlert(message: String) {
  alert(message){}.show()
}

fun Context.showNotCancellableAlert(message: String) {
alert(message){}.show().setCancelable(false)
}

fun Context.showNotCancellableAlert(message: Int, callback: AlertDialogCallback) {
    lateinit var dialog: DialogInterface
    alert {
        titleResource = R.string.app_name
        messageResource = message
        yesButton {dialog ->
            dialog.dismiss()
            callback.onPositiveButtonClicked()
        }
        }.show()

}

fun Context.showConfirmationDialog(callback: AlertDialogCallback, message: String, positiveButton: String = "OK", negativeButton: String = "Cancel") {
    lateinit var dialog: DialogInterface
    alert {
        title = getString(R.string.app_name)
        positiveButton(positiveButton){
            dialog.dismiss()
            callback.onPositiveButtonClicked()
        }
        negativeButton(negativeButton){
             dialog.dismiss()
        }
    }.show()
}

fun Context.showPermissionRequestDialog(message: Int) {
    showConfirmationDialog(object : AlertDialogCallback {
        override fun onPositiveButtonClicked() {
            val i = Intent()
            i.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            i.addCategory(Intent.CATEGORY_DEFAULT)
            i.data = Uri.parse("package:$packageName")
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
            startActivity(i)
        }

        override fun onNegativeButtonClicked() {
        }
    }, getString(message), positiveButton = "Settings", negativeButton = "Not Now")
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.showToast(message: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun ViewGroup.changeFont(fontPath: String) {
    for (i in 0 until childCount) {
        val child = getChildAt(i)
        if (TextView::class.java.isAssignableFrom(child.javaClass)) {
            CalligraphyUtils.applyFontToTextView(child.context, child as TextView, fontPath)
        } else if (ViewGroup::class.java.isAssignableFrom(child.javaClass)) {
            (getChildAt(i) as ViewGroup).changeFont(fontPath)
        }
    }
}

fun TextView.setFirstLetterCapitalisedText(string: String) {
    val capitalisedText = Character.toUpperCase(string[0]) + string.substring(1)
    text = capitalisedText
}

private fun capitalize(line: String): String {
    return Character.toUpperCase(line[0]) + line.substring(1)
}

fun BigDecimal.roundUpTo2DecimalPlaces(): BigDecimal {
    return this.setScale(2, BigDecimal.ROUND_HALF_UP)
}

interface AlertDialogCallback {
    fun onPositiveButtonClicked()
    fun onNegativeButtonClicked()
}

