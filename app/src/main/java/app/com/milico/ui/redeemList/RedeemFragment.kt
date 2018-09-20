package app.com.milico.ui.redeemList

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
import app.com.milico.ui.dashboard.DashBoardFragment
import app.com.milico.ui.dashboard.DashBoardModel
import app.com.milico.ui.main.IFragmentListener
import app.com.milico.ui.main.MainViewModel
import app.com.milico.ui.redeemValuePopUp.RedeemValueDialog
import app.com.milico.util.extensions.convertDpToPixel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_redeem.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class RedeemFragment : BaseFragment<FragmentRedeemBinding>() {


    private val mainViewModel: MainViewModel by sharedViewModel()

    private var redeemValueDialog: RedeemValueDialog? = null

    private val gson = Gson()

    private val userData: DashBoardModel.Data by lazy {
        arguments!!.getParcelable(DashBoardFragment.DASHBOARDMODEL) as DashBoardModel.Data
    }

    lateinit var iFragmentListener: IFragmentListener

    companion object {
        const val TAG: String = "RedeemFragment"
        fun newInstance(dashBoardModel: DashBoardModel.Data): RedeemFragment {
            val redeemFragment = RedeemFragment()
            val bundle = Bundle()
            bundle.putParcelable(DashBoardFragment.DASHBOARDMODEL, dashBoardModel)
            redeemFragment.arguments = bundle
            return redeemFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()

    }

    override fun getLayout(): Int = R.layout.fragment_redeem


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IFragmentListener) {
            iFragmentListener = context
        }
    }

    override fun initBinder() {

        dataBinding.viewModel = mainViewModel.apply {

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



            adapters.setOnItemClickListener(object : RedeemAdapter.OnItemClickListener {
                override fun onClick(view: View, data: RedeemModel.AdapterModel) {
                    var x: Int = 0
                    var y: Int = 0
                    val firstVisibleItem: Int = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val lastVisibleItem: Int = layoutManager.findLastCompletelyVisibleItemPosition()

                    //getting the full width of screen
                    val displayMetrics = DisplayMetrics()
                    activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
                    val width = displayMetrics.widthPixels
                    mainViewModel.position = data.position
                    y = rvGiftsCards.y.toInt()

                    if ((data.position < firstVisibleItem)) { //if first visible item is not completely seen, show dialog from the x=0
                        x = 0
                    } else if ((data.position > lastVisibleItem)) { //if final visible item is not completely seen, keep the end of dialog to x=width of screen
                        x = width - convertDpToPixel(resources.getDimension(R.dimen.dialog_width).toInt()).toInt()
                    } else {//else original value of x
                        x = view.x.toInt()
                    }

                    dataBinding.viewModel = mainViewModel.apply {

                        confirmClickEvent.observe(this@RedeemFragment, Observer {
                            dataModel.apply {
                                Log.d("dataposition",data.position.toString())
                                Log.d("quantity",it!!.quantity.toString())
                                giftCardInfo!![position].quantity= it!!.quantity
                                giftCardInfo[position].redeemPrice = it.price
                                Log.d("datamodel",gson.toJson(dataModel))
                                adapters.notifyDataSetChanged()
                            }

                        })

                    }

                    //for smooth scrolling of partially visible item
                    smoothScrollToPosition(data.position)

                    redeemValueDialog = RedeemValueDialog.newInstance(x,y)
                    redeemValueDialog!!.show(fragmentManager, RedeemValueDialog.TAG)




                }

            })
        }

    }


}