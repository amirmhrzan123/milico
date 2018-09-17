package app.com.milico.data.remote

import app.com.milico.base.BaseResponse
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.ui.homeScreen.HomeScreenModel
import app.com.milico.ui.splash.RegisterModel
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IApiService {

    @POST(EndPoint.Device.REGISTER)
    fun registerDevice(@Body deviceRegisterRequestModel: RegisterModel.DeviceRegisterRequestModel): Observable<BaseResponse<Any>>

    @POST(EndPoint.Device.LANDING_PAGE)
    fun getLandingInfo(@Body homeScreenRequestModel: HomeScreenModel.HomeScreenRequestModel): Observable<BaseResponse<HomeScreenModel.Data>>

    @POST(EndPoint.Card.LOGINCARD)
    fun getCardInfo(@Body cardRequestModel: DashBoardModel.CardRequestModel):Observable<DashBoardModel.ResponseModel>




}

class EndPoint{
    object Device{
        const val REGISTER = "device/register-device"
        const val LANDING_PAGE = "device/landing-page"

    }

    object Card{
        const val LOGINCARD = "card/login-card"
    }
}

class Keys{
    companion object {
        const val AUTHORIZATION ="authorization"

    }

}