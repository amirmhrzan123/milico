package app.com.milico.ui.redeem

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.com.milico.base.Binder
import app.com.milico.data.local.json.GiftCard
import app.com.milico.data.local.json.JsonModel
import app.com.milico.databinding.ItemGiftCardBinding

class RedeemAdapter constructor(
        private val giftcardsList: MutableList<GiftCard> = arrayListOf()
        ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var listener: OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        setOnItemClickListener(listener)
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
                model = giftcardsList[position]
                root.setOnClickListener{
                    var redeemModel = RedeemModel.AdapterModel(position,giftcardsList[position].id)
                    listener.onClick(it,redeemModel)
                }
                executePendingBindings()

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

    interface OnItemClickListener {
        fun onClick(view: View, data: RedeemModel.AdapterModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}