package app.com.milico.ui.splash
import com.google.gson.annotations.SerializedName

class RegisterModel{

    data class DeviceRegisterRequestModel(
            @SerializedName("device_uuid") val deviceUuid: String,
            @SerializedName("device_name") val deviceName: String,
            @SerializedName("device_os") val deviceOs: String,
            @SerializedName("device_timezone") val deviceTimezone: String,
            @SerializedName("device_locale") val deviceLocale: String
    )

}

