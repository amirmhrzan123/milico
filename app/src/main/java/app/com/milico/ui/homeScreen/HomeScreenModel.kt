package app.com.milico.ui.homeScreen

import com.google.gson.annotations.SerializedName


class HomeScreenModel {
    data class HomeScreenRequestModel(
            @SerializedName("device_uuid") val deviceUuid: String
    )

data class HomeScreenResponseModel(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("club_id") val clubId: Int,
    @SerializedName("club_logo") val clubLogo: String,
    @SerializedName("app_logo") val appLogo: String,
    @SerializedName("app_information") val appInformation: String,
    @SerializedName("cover_image") val coverImage: List<String>
)
}