package app.com.milico.ui.pin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.View
import app.com.milico.R
import app.com.milico.base.BaseFragment
import app.com.milico.databinding.FragmentEnterPinBinding
import kotlinx.android.synthetic.main.fragment_enter_pin.*
import org.koin.android.ext.android.inject

class EnterPinFragment : BaseFragment<FragmentEnterPinBinding>() {

    private val enterPinViewModel : EnterPinViewModel by inject()

    private var keys : String =""

    private var numberLength: Int = 0



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
                checkLength("1")
            })

            twoPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("2")
            })

            threePressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("3")
            })

            fourPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("4")
            })

            fivePressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("5")
            })

            sixPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("6")
            })

            sevenPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("7")
            })

            eightPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("8")
            })

            ninePressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("9")
            })

            zeroPressedEvent.observe(this@EnterPinFragment, Observer {
                checkLength("0")
            })

            okPressedEvent.observe(this@EnterPinFragment, Observer {

            })

            backPressedEvent.observe(this@EnterPinFragment, Observer {
                if(keys.length>0){
                    keys = keys.replace(keys.substring(keys.length-1), "")
                    Log.d("string",keys)

                }
                setImageSources()


            })

            forgottenPasswordEvent.observe(this@EnterPinFragment, Observer {

            })
        }
    }

    fun checkLength(number: String){
        if(keys.length <4){
            keys += number
            Log.d("string",keys)

        }
        setImageSources()
    }

    fun setImageSources(){
        when(keys.length){
            0->{
                iv_first.setImageResource(R.drawable.keypad_circle_one)
                iv_second.setImageResource(R.drawable.keypad_circle_one)
                iv_third.setImageResource(R.drawable.keypad_circle_one)
                iv_fourth.setImageResource(R.drawable.keypad_circle_one)
            }
            1-> {
                iv_first.setImageResource(R.drawable.keypad_circle_two)
                iv_second.setImageResource(R.drawable.keypad_circle_one)
                iv_third.setImageResource(R.drawable.keypad_circle_one)
                iv_fourth.setImageResource(R.drawable.keypad_circle_one)
            }
            2-> {
                iv_first.setImageResource(R.drawable.keypad_circle_two)
                iv_second.setImageResource(R.drawable.keypad_circle_two)
                iv_third.setImageResource(R.drawable.keypad_circle_one)
                iv_fourth.setImageResource(R.drawable.keypad_circle_one)
            }
            3->{
                iv_first.setImageResource(R.drawable.keypad_circle_two)
                iv_second.setImageResource(R.drawable.keypad_circle_two)
                iv_third.setImageResource(R.drawable.keypad_circle_two)
                iv_fourth.setImageResource(R.drawable.keypad_circle_one)
            }
            4->{
                iv_first.setImageResource(R.drawable.keypad_circle_two)
                iv_second.setImageResource(R.drawable.keypad_circle_two)
                iv_third.setImageResource(R.drawable.keypad_circle_two)
                iv_fourth.setImageResource(R.drawable.keypad_circle_two)
            }
        }
    }


}


