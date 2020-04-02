package com.kawakuticode.radionics_ao.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.models.Radio_Station
import kotlinx.android.synthetic.main.r_player_fragment.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */


class SecondFragment : Fragment() {


    companion object {
        private const val RADIOMODEL = "radio_st"
        fun newInstance(radio_st: Radio_Station): SecondFragment {
            val args = Bundle()
            args.putSerializable(RADIOMODEL, radio_st)
            val fragment = SecondFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.r_player_fragment, container,
            false
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val curr_station = arguments!!.getSerializable(RADIOMODEL) as Radio_Station
        n_radio.text = curr_station.name
    }
}

