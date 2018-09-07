package app.com.milico.di


import android.content.Context
import android.content.res.Resources
import app.com.milico.R
import app.com.milico.data.local.json.AndroidJsonReader
import app.com.milico.data.local.json.JsonReader
import np.com.amir.apptest.util.ApplicationSchedulerProvider
import np.com.amir.apptest.util.SchedulerProvider
import org.koin.dsl.module.module
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


val otherModules = module {
    single {
        ApplicationSchedulerProvider() as SchedulerProvider
    }

    single { provideResources(get())}

    single{ provideCalligraphy(get())}

    single { AndroidJsonReader(get()) as JsonReader }

}



val appModule = listOf(viewModelModule, otherModules,dataModule,netModules)



/*
@SuppressLint("HardwareIds")
@Named(DEVICE_ID)
fun provideDeviceId(application: Application): String = Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
*/

//Gather all app Modules




fun provideResources(context: Context): Resources = context.resources

fun provideCalligraphy(context: Context): CalligraphyConfig =
        CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getString(R.string.font_regulat))
                .setFontAttrId(R.attr.fontPath)
                .build()




