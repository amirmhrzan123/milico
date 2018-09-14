package app.com.milico.ui.review.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.com.milico.R

/**
Created by Prajeet on 9/10/2018, 4:40 PM
 **/
class ReviewCardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_card, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = 5

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {

        }
    }
}
