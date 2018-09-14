package app.com.milico.ui.review

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentReviewBinding
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
        with(rvReview) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ReviewCardAdapter()
            isNestedScrollingEnabled = false
        }
    }
}