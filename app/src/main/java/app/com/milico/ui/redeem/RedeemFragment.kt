package app.com.milico.ui.redeem

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentRedeemBinding
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.util.extensions.convertDpToPixel
import kotlinx.android.synthetic.main.fragment_redeem.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class RedeemFragment:BaseFragment<FragmentRedeemBinding>() {


    private val redeemViewModel: RedeemViewModel by viewModel()

    private var redeemValueDialog: RedeemValueDialog? = null



    lateinit var iFragmentListener: IFragmentListener

    companion object {
        const val TAG: String = "RedeemFragment"
        fun newInstance():RedeemFragment{
            return RedeemFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()

    }

    override fun getLayout(): Int = R.layout.fragment_redeem


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is IFragmentListener){
            iFragmentListener = context
        }
    }

    override fun initBinder() {

        dataBinding.viewModel = redeemViewModel.apply {
            getGiftsCards()

            checkOutEvent.observe(this@RedeemFragment, Observer {
                iFragmentListener.openReview()
            })


        }

        dataBinding.rvGiftsCards.apply {

            val layoutManager = LinearLayoutManager(baseActivity).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            this.layoutManager = layoutManager
            val adapters = RedeemAdapter()
            dataBinding.viewModel?.let {

                adapter = adapters
            }

            adapters.setOnItemClickListener(object: RedeemAdapter.OnItemClickListener{
                override fun onClick(view: View, data: RedeemModel.AdapterModel) {
                    var x : Int = 0
                    var y : Int = 0
                    val firstVisibleItem: Int = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val lastVisibleItem: Int = layoutManager.findLastCompletelyVisibleItemPosition()
                    val displayMetrics = DisplayMetrics()
                    activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
                    var width = displayMetrics.widthPixels
                    var height = displayMetrics.heightPixels
                    if((data.position<firstVisibleItem)){
                        Log.d("herefirst","first")
                        x=0
                        y=rvGiftsCards.y.toInt()
                    }else if((data.position>lastVisibleItem)){
                        Log.d("herefirst","seconde")
                        x=width-convertDpToPixel(520).toInt()
                        y= rvGiftsCards.y.toInt()
                    }else{
                        x=view.x.toInt()
                        Log.d("herefirst","third")

                        y=rvGiftsCards.y.toInt()
                    }
                    redeemViewModel.setXYvalue(x,y)
                    Log.d("xyvalue",redeemViewModel.getXvalue().toString()+"  "+redeemViewModel.getYvalue().toString())
                    Log.d("lastvisiblepositon",layoutManager.findLastCompletelyVisibleItemPosition().toString())
                    Log.d("firstVisibleposition",layoutManager.findFirstCompletelyVisibleItemPosition().toString())

                    smoothScrollToPosition(data.position)

                    Log.d("POSITION_X",view.x.toString())
                    Log.d("POSITION_Y",rvGiftsCards.y.toString())
                    redeemValueDialog = RedeemValueDialog.newInstance(x,y)
                    redeemValueDialog!!.show(fragmentManager, RedeemValueDialog.TAG)
                }

            })
        }

    }




}