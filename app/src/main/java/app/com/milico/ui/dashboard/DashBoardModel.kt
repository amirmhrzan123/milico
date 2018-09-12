package app.com.milico.ui.dashboard

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


class DashBoardModel {

    @Parcelize
    data class ResponseModel(
            @SerializedName("status") val status: Int,
            @SerializedName("message") val message: String,
            @SerializedName("data") val data: Data
    ) : Parcelable

    @Parcelize
    data class Data(
            @SerializedName("card-info") val cardInfo: CardInfo,
            @SerializedName("gift-card-info") val giftCardInfo: List<GiftCardInfo>,
            @SerializedName("user") val user: User
    ):Parcelable

    @Parcelize
    data class GiftCardInfo(
            @SerializedName("ProductName") val productName: String,
            @SerializedName("ProductDescription") val productDescription: String,
            @SerializedName("ProductThumbnailUrl") val productThumbnailUrl: String
    ):Parcelable

    @Parcelize
    data class CardInfo(
            @SerializedName("name") val name: String,
            @SerializedName("membership_status") val membershipStatus: String,
            @SerializedName("membership_expiry") val membershipExpiry: String,
            @SerializedName("email") val email: String,
            @SerializedName("loyalty_point") val loyaltyPoint: String,
            @SerializedName("loyalty_value") val loyaltyValue: String
    ):Parcelable

    @Parcelize
    data class User(
            @SerializedName("id") val id: Int,
            @SerializedName("identity") val identity: String,
            @SerializedName("card_id") val cardId: String,
            @SerializedName("pin") val pin: String,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("updated_at") val updatedAt: String,
            @SerializedName("auth_token") val authToken: String
    ):Parcelable

    @Parcelize
    data class CardRequestModel(
            @SerializedName("card_id") val cardId: String,
            @SerializedName("pin") val pin: String
    ):Parcelable
}