package app.com.milico.util.bindings

import android.databinding.BindingAdapter
import android.widget.ImageView
import app.com.milico.util.extensions.loadImage


object BindingAdapters {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        with(imageView) {
           loadImage(url)
        }
    }


}
