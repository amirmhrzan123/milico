package app.com.milico.di

import app.com.milico.ui.dashboard.DashBoardViewModel
import app.com.milico.ui.editQuantityDialog.EditQuantityViewModel
import app.com.milico.ui.homeScreen.HomeScreenViewModel
import app.com.milico.ui.main.MainViewModel
import app.com.milico.ui.pin.EnterPinViewModel
import app.com.milico.ui.redeemValuePopUp.RedeemValueViewModel
import app.com.milico.ui.splash.SplashViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel { SplashViewModel(get(), get(), get()) }
    viewModel { HomeScreenViewModel(get(),get(),get()) }
    viewModel { EnterPinViewModel(get(), get(), get()) }
    viewModel { MainViewModel(get(),get(), get(),get()) }
    viewModel { DashBoardViewModel(get(),get()) }
    viewModel { RedeemValueViewModel(get())}
    viewModel{EditQuantityViewModel(get())}

}