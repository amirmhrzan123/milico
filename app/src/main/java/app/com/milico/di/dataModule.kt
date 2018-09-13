package app.com.milico.di

import android.content.Context
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.preference.PreferenceHelper
import app.com.milico.data.remote.IApiService
import app.com.milico.data.repository.AppDataManager
import com.google.gson.Gson
import org.koin.dsl.module.module

val dataModule = module {


    //single (override = true){ provideApiServiceHolder()}
    single{ provideSharedPreference(get())}

    single{provideDataManager(get(),get(),get())}

}




fun provideDataManager(iApiService: IApiService,
                       gsons: Gson,iPreferenceHelper: IPreferenceHelper): AppDataManager = AppDataManager(iApiService,
        iPreferenceHelper,gsons)




fun provideSharedPreference(context:Context): IPreferenceHelper = PreferenceHelper(context)



