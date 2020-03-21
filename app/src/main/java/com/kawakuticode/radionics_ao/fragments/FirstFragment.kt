package com.kawakuticode.radionics_ao.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.adapters.RadioListAdapter
import com.kawakuticode.radionics_ao.models.Radio_Station


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), RadioListAdapter.OnItemClickListener {

    private lateinit var radapter: RadioListAdapter

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.radio_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        radapter = RadioListAdapter(activity , radio_stations, this)
        recyclerView.adapter = radapter
        return view
    }


    override fun onItemClicked(radio_station: Radio_Station) {
        Toast.makeText(
                this.context,
                "Radio name ${radio_station.name} \n url:${radio_station.station_url}",
                Toast.LENGTH_LONG
            )
            .show()
        Log.d("radio name ", radio_station.toString())




    }
}

