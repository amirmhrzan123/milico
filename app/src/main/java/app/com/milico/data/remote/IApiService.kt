package app.com.milico.data.remote

import app.com.milico.base.BaseResponse
import app.com.milico.ui.splash.RegisterModel
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IApiService {

    @POST(EndPoint.Device.REGISTER)
    fun registerDevice(@Body deviceRegisterRequestModel: RegisterModel.DeviceRegisterRequestModel): Observable<BaseResponse<Any>>




}

class EndPoint{
    object Device{
        const val REGISTER = "device/register-device"

    }
}

class Keys{
    companion object {
        const val AUTHORIZATION ="authorization"
    }

}