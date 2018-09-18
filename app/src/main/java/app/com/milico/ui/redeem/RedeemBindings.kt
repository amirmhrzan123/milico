package app.com.milico.ui.redeem

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import app.com.milico.ui.dashboard.DashBoardModel

object RedeemBindings{
    @BindingAdapter("giftsCardList")
    @JvmStatic
    fun setGiftCardList(recyclerView: RecyclerView, redeemResults: DashBoardModel.Data?) {
        with(recyclerView.adapter as RedeemAdapter) {
            redeemResults?.let {
                setLoyaltyGiftsCards(it)
            }
        }
    }

    @BindingAdapter("giftCardCount")
    @JvmStatic
    fun setGiftsCardCount(textView: TextView, count: Int?) {
        with(textView) {
            if (count == null || count == 0) {
                visibility = View.GONE
            } else {
                visibility = View.VISIBLE
                text = count.toString()
            }
        }
    }


}