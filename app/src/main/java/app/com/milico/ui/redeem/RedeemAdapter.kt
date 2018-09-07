package app.com.milico.ui.redeem

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.com.milico.base.Binder
import app.com.milico.data.local.json.GiftCard
import app.com.milico.data.local.json.JsonModel
import app.com.milico.databinding.ItemGiftCardBinding

class RedeemAdapter constructor(
        private val redeemViewModel: RedeemViewModel,
        private val giftcardsList: MutableList<GiftCard> = arrayListOf()
        ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ItemGiftCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int = giftcardsList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.onBind(position)
        }
    }

    inner class ViewHolder(private val  itemGiftCardBinding: ItemGiftCardBinding):RecyclerView.ViewHolder(itemGiftCardBinding.root), Binder {
        override fun onBind(position: Int) {

            with(itemGiftCardBinding){


            }
        }

    }

    fun setLoyaltyGiftsCards(giftsCardModel: JsonModel){
        giftsCardModel.let {
            giftcardsList.clear()
            giftcardsList.addAll(it.giftCards)
            notifyDataSetChanged()
        }
    }


}