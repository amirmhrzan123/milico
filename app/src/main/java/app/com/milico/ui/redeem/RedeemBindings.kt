package app.com.milico.ui.redeem

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import app.com.milico.data.local.json.JsonModel

object RedeemBindings{
    @BindingAdapter("giftsCardList")
    @JvmStatic
    fun setGiftCardList(recyclerView: RecyclerView, notificationListResult: JsonModel?) {
        with(recyclerView.adapter as RedeemAdapter) {
            notificationListResult?.let {
                setLoyaltyGiftsCards(it)
            }
        }
    }
}