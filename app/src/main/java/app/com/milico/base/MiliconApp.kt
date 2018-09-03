package app.com.milico.base

import android.support.multidex.MultiDexApplication
import app.com.milico.util.extensions.initCalligraphy
import app.com.milico.util.extensions.initKoin
import org.koin.android.ext.android.inject
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MiliconApp: MultiDexApplication() {
     val calligraphyConfig: CalligraphyConfig by inject()



    override fun onCreate() {
        super.onCreate()
       // initCatalytic()
        initKoin()

        initCalligraphy(calligraphyConfig)
       // InAppTranslation.setTargetLanguage("en")
    }
}