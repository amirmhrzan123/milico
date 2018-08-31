package app.com.milico.di

import app.com.milico.ui.splash.SplashViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel { SplashViewModel(get(), get()) }


}