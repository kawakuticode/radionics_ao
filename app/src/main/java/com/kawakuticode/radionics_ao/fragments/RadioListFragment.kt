package com.kawakuticode.radionics_ao.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.adapters.RadioListAdapter
import com.kawakuticode.radionics_ao.adapters.RadioListAdapter.OnRadioSelected
import com.kawakuticode.radionics_ao.models.Radio_Station


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RadioListFragment : Fragment() {

    private lateinit var radapter: RadioListAdapter
    private lateinit var listener: OnRadioSelected
    private val radio_stations = listOf<Radio_Station>(
        Radio_Station(
            "N'Gola Yetu",
            "http://radios.sapo.ao/ngola-yetu",
            "http://radios.vpn.sapo.pt/AO/radio12.mp3",
            "http://imgs.sapo.pt/radiosonlineao/content/img/n_gola_yetu.jpg"
        ),
        Radio_Station(
            "Canal A",
            "http://radios.sapo.ao/canal-a",
            "http://radios.vpn.sapo.pt/AO/radio3.mp3",
            "http://imgs.sapo.pt/radiosonlineao/content/img/canala.jpg"
        ),
        Radio_Station(
            "LAC",
            "http://radios.sapo.ao/lac",
            "http://radios.vpn.sapo.pt/AO/radio14.mp3",
            "http://imgs.sapo.pt/radiosonlineao/content/img/lac.jpg"
        )
    )

    companion object {

        fun newInstance(): RadioListFragment {
            return RadioListFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRadioSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnDogSelected.")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.radio_list_fragment, container, false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.radio_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        radapter = RadioListAdapter(activity, radio_stations, listener)
        recyclerView.adapter = radapter
        return view
    }
}


