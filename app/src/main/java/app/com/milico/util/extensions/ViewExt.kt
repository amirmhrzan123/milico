package app.com.milico.util.extensions

import android.widget.ImageView
import app.com.milico.R

fun ImageView.loadImage(url: String?) {
    if (!url.isNullOrEmpty()) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.color.background)
                .into(this)
    } else {
        GlideApp.with(context)
                .load(R.color.background)
                .placeholder(R.color.background)
                .into(this)
    }
}