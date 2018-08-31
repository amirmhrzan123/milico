package app.com.milico.di


import android.app.Application
import android.content.res.Resources
import np.com.amir.apptest.util.ApplicationSchedulerProvider
import np.com.amir.apptest.util.SchedulerProvider
import org.koin.dsl.module.module





val otherModules = module {
    single {
        ApplicationSchedulerProvider() as SchedulerProvider
    }

    single { provideResources(get())}

}



val appModule = listOf(viewModelModule, otherModules,dataModule,netModules)



/*
@SuppressLint("HardwareIds")
@Named(DEVICE_ID)
fun provideDeviceId(application: Application): String = Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
*/

//Gather all app Modules




fun provideResources(application: Application): Resources = application.resources




