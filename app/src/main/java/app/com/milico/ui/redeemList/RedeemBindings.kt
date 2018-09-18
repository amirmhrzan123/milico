package app.com.milico.ui.redeemList

import android.databinding.BindingAdapter
import android.view.View
import android.widget.LinearLayout
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

    @BindingAdapter("editedCardCount")
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

    @BindingAdapter("quantity","redeemValue")
    @JvmStatic
    fun showHideLinearLayout(linearLayout: LinearLayout,quantity:Int,redeemValue:Float){
        with(linearLayout){
            if(quantity == 0 && redeemValue==0f){
                visibility = View.INVISIBLE
            }else{
                visibility = View.VISIBLE
            }
        }
    }




}