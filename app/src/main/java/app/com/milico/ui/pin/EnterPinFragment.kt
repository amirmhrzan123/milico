package app.com.milico.ui.pin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentEnterPinBinding
import org.koin.android.ext.android.inject

class EnterPinFragment : BaseFragment<FragmentEnterPinBinding>() {

    private val enterPinViewModel : EnterPinViewModel by inject()

    private var keys : String ? = null

    private var numberLength: Int = 0;



    companion object {
        const val TAG: String = "EnterPinFragment"
        fun newInstance(): EnterPinFragment = EnterPinFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinder()
    }

    override fun getLayout(): Int = R.layout.fragment_enter_pin


    override fun initBinder() {
        dataBinding.viewModel = enterPinViewModel.apply {

            onePressedEvent.observe(this@EnterPinFragment, Observer {

            })

            twoPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            threePressedEvent.observe(this@EnterPinFragment, Observer {

            })

            fourPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            fivePressedEvent.observe(this@EnterPinFragment, Observer {

            })

            sixPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            sevenPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            eightPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            ninePressedEvent.observe(this@EnterPinFragment, Observer {

            })

            zeroPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            okPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            backPressedEvent.observe(this@EnterPinFragment, Observer {

            })
        }
    }


}