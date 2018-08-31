package app.com.milico.base

import android.support.multidex.MultiDexApplication
import com.milico.base.MiliconApp.initKoin

class MiliconApp: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
       // initCatalytic()
        initKoin()
       // InAppTranslation.setTargetLanguage("en")
    }
}