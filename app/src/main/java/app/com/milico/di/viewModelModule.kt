package app.com.milico.di

import app.com.milico.ui.homeScreen.HomeScreenViewModel
import app.com.milico.ui.main.MainViewModel
import app.com.milico.ui.pin.EnterPinViewModel
import app.com.milico.ui.splash.SplashViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel { SplashViewModel(get(), get()) }
    viewModel { HomeScreenViewModel(get(),get()) }
    viewModel { EnterPinViewModel(get(),get()) }
    viewModel { MainViewModel(get(),get()) }


}