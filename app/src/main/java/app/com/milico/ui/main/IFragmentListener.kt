package app.com.milico.ui.main

import app.com.milico.ui.dashboard.DashBoardModel

interface IFragmentListener {

    fun openHomeScreen()

    fun openPinKeyScreen()


    fun openDashBoard(dashboardModel: DashBoardModel.ResponseModel?)

    fun openRedeemPage()

    fun hideShowToolbar()

    fun openReview()
    fun openUpdateEmail()

}