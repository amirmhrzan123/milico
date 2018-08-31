package app.com.milico.di

import android.arch.persistence.room.Room
import android.content.Context
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.preference.PreferenceHelper
import app.com.milico.data.remote.ApiServiceHolder
import app.com.milico.data.remote.IApiService
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import np.com.amir.apptest.data.local.InAppDatabase
import np.com.amir.apptest.data.local.dbHelper.DbHelper
import np.com.amir.apptest.data.local.dbHelper.IDbHelper
import np.com.amir.apptest.data.local.handlers.DbThread
import np.com.amir.apptest.data.repository.AppDataManager
import np.com.amir.apptest.data.repository.IAppDataManager
import org.koin.dsl.module.module

val dataModule = module {

    single { provideRoomDatabase(get())}
    single{ provideDbThread()}
    single{ provideDataManager(get(),get(),get(),get(),get())}
    single{ provideDbHelper(get())}
    single{ provideApiServiceHolder()}
    single{ provideSharedPreference(get())}

}

fun provideRoomDatabase(context: Context): InAppDatabase {
    return Room.databaseBuilder(context, InAppDatabase::class.java, "BingoDatabase").addMigrations().fallbackToDestructiveMigration().build()
}

fun provideDbThread(): DbThread {
    lateinit var mDbWorkerThread: DbThread
    mDbWorkerThread = DbThread("dbWorkerThread")
    mDbWorkerThread.start()
    return mDbWorkerThread
}

fun provideDataManager(iApiService: IApiService, appDbHelper: IDbHelper, preferenceHelper: IPreferenceHelper,
                       compositeDisposable: CompositeDisposable,gsons:Gson): IAppDataManager = AppDataManager(iApiService, preferenceHelper, appDbHelper, compositeDisposable,gsons)


fun provideDbHelper(appDatabase: InAppDatabase): DbHelper = DbHelper(appDatabase)

fun provideApiServiceHolder(): ApiServiceHolder = ApiServiceHolder()

fun provideSharedPreference(context:Context): IPreferenceHelper = PreferenceHelper(context)



