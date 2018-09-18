package app.com.milico.ui.review

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.View
import android.widget.TextView.BufferType
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentReviewBinding
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.ui.review.adapter.ReviewCardAdapter
import kotlinx.android.synthetic.main.fragment_review.*


/**
Created by Prajeet on 9/10/2018, 4:29 PM
 **/

class ReviewFragment : BaseFragment<FragmentReviewBinding>() {

    companion object {
        fun getInstance(): ReviewFragment = ReviewFragment()
    }

    override fun getLayout() = R.layout.fragment_review

    override fun initBinder() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()


    }

    private fun init() {
        //Set review adapter
        with(rvReview) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ReviewCardAdapter()
            isNestedScrollingEnabled = false
        }

        tvLostNote.text = Html.fromHtml("\uD83D  " + resources.getString(R.string.note_lost_print))

        btnCheckOut.setOnClickListener {
            grReview.visibility = View.GONE
            grCheckout.visibility = View.VISIBLE
        }

        editEmailView.setOnClickListener {
            iFragmentListener.openUpdateEmail()
        }
    }

    private lateinit var iFragmentListener: IFragmentListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IFragmentListener) {
            iFragmentListener = context
        }
    }
}