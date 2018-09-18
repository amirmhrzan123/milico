package app.com.milico.ui.redeem

import android.databinding.BindingAdapter
import android.view.View
import android.widget.TextView
import app.com.milico.ui.dashboard.DashBoardModel
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView

object RedeemBindings{
    @BindingAdapter("giftsCardList")
    @JvmStatic
    fun setGiftCardList(recyclerView: FastScrollRecyclerView, redeemResults: DashBoardModel.Data?) {
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