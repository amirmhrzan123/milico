package app.com.milico.di

import android.arch.persistence.room.Room
import android.content.Context
import app.com.milico.data.local.dbHelper.DbHelper
import app.com.milico.data.local.dbHelper.IDbHelper
import app.com.milico.data.local.handlers.DbThread
import app.com.milico.data.preference.IPreferenceHelper
import app.com.milico.data.preference.PreferenceHelper
import app.com.milico.data.remote.IApiService
import app.com.milico.data.repository.AppDataManager
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import np.com.amir.apptest.data.local.InAppDatabase
import org.koin.dsl.module.module

val dataModule = module {

    single { provideRoomDatabase(get())}
    single{ provideDbThread()}

    single{ provideDbHelper(get())}
    //single (override = true){ provideApiServiceHolder()}
    single{ provideSharedPreference(get())}

    single{provideDataManager(get(),get(),get(),get(),get())}

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

fun provideDataManager(iApiService: IApiService,compositeDisposable: CompositeDisposable,
                       gson: Gson,iDbHelper: IDbHelper,iPreferenceHelper: IPreferenceHelper): AppDataManager = AppDataManager(iApiService,
        iPreferenceHelper,iDbHelper,compositeDisposable,gson)


fun provideDbHelper(appDatabase: InAppDatabase): IDbHelper = DbHelper(appDatabase)

//fun provideApiServiceHolder(): ApiServiceHolder = ApiServiceHolder()

fun provideSharedPreference(context:Context): IPreferenceHelper = PreferenceHelper(context)



