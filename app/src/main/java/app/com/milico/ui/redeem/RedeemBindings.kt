package app.com.milico.ui.redeem

import android.databinding.BindingAdapter
import app.com.milico.data.local.json.JsonModel
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView

object RedeemBindings{
    @BindingAdapter("giftsCardList")
    @JvmStatic
    fun setGiftCardList(recyclerView: FastScrollRecyclerView, notificationListResult: JsonModel?) {
        with(recyclerView.adapter as RedeemAdapter) {
            notificationListResult?.let {
                setLoyaltyGiftsCards(it)
            }
        }
    }
}