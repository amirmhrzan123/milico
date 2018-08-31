package app.com.milico.util.extensions


import app.com.milico.base.MiliconApp
import app.com.milico.di.appModule
import org.koin.android.ext.android.startKoin

fun MiliconApp.initKoin() {
    startKoin(this, appModule)
}

fun MiliconApp.initCatalytic(){
    //Fabric.with(this, Crashlytics())
}