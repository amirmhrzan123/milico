package app.com.milico.base

import android.support.multidex.MultiDexApplication
import app.com.milico.util.extensions.initKoin

class MiliconApp: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
       // initCatalytic()
        initKoin()
       // InAppTranslation.setTargetLanguage("en")
    }
}