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
            @SerializedName("user") val user: User,
            @SerializedName("club_info") val club: ClubInfo,
            val totalRedeemPoint: Float = 0f
    ) : Parcelable

    @Parcelize
    data class GiftCardInfo(
            @SerializedName("id") val id: Int,
            @SerializedName("SKU") val sku: String,
            @SerializedName("ProductName") val productName: String,
            @SerializedName("ProductDescription") val productDescription: String,
            @SerializedName("ProductThumbnailUrl") val productThumbnailUrl: String,
            var quantity: Int = 0,
            var redeemPoint: Float = 0f,
            val confirm:Boolean = false
    ) : Parcelable

    @Parcelize
    data class CardInfo(
            @SerializedName("name") val name: String,
            @SerializedName("membership_status") val membershipStatus: String,
            @SerializedName("membership_expiry") val membershipExpiry: String,
            @SerializedName("email") val email: String,
            @SerializedName("loyalty_point") val loyaltyPoint: String,
            @SerializedName("loyalty_value") val loyaltyValue: String
    ) : Parcelable

    @Parcelize
    data class User(
            @SerializedName("id") val id: Int,
            @SerializedName("identity") val identity: String,
            @SerializedName("card_id") val cardId: String,
            @SerializedName("pin") val pin: String,
            @SerializedName("created_at") val createdAt: String,
            @SerializedName("updated_at") val updatedAt: String,
            @SerializedName("auth_token") val authToken: String
    ) : Parcelable


    @Parcelize
    data class ClubInfo(
            @SerializedName("id") val id:Int,
            @SerializedName("name") val name:String,
            @SerializedName("float-balance") val floatBalance:Float,
            @SerializedName("minimum-float") val minimumFloat:Float
    ):Parcelable

    @Parcelize
    data class CardRequestModel(
            @SerializedName("card_id") val cardId: String,
            @SerializedName("pin") val pin: Int,
            @SerializedName("device_uuid") val deviceId: String,
            @SerializedName("club_id") val clubId: Int
    ) : Parcelable


    data class GiftsCardRequestModel(
            @SerializedName("club_id") val clubId: Int,
            @SerializedName("device_id") val deviceId: String,
            @SerializedName("card_user_id") val cardUserId: Int,
            @SerializedName("total_redeem_point") val totalRedeemPoint: Float,
            @SerializedName("redeemDetail") val redeemDetail: List<RedeemDetail>
    )

    @Parcelize
    data class RedeemDetail(
            @SerializedName("gift_card_id") val giftCardId: Int,
            @SerializedName("quantity") val quantity: Int,
            @SerializedName("redeem_point") val redeemPoint: Float
    ):Parcelable
}