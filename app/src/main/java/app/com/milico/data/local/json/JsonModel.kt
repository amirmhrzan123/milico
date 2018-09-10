package app.com.milico.data.local.json
import com.google.gson.annotations.SerializedName



data class JsonModel(
    @SerializedName("gift_cards") val giftCards: List<GiftCard>,
    @SerializedName("total_loyalty") val totalLoyalty: Int
)

data class GiftCard(
    @SerializedName("id") val id: Int,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("loyalty") val loyalty: Boolean
)