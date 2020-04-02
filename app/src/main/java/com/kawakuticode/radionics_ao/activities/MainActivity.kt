package com.kawakuticode.radionics_ao.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.adapters.RadioListAdapter
import com.kawakuticode.radionics_ao.fragments.RadioListFragment
import com.kawakuticode.radionics_ao.fragments.SecondFragment
import com.kawakuticode.radionics_ao.models.Radio_Station

class MainActivity : AppCompatActivity(), RadioListAdapter.OnRadioSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_layout, RadioListFragment.newInstance(), "radioList")
                .commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onRadioSelected(radio_station: Radio_Station) {
        val player_fragment = SecondFragment.newInstance(radio_station)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_layout, player_fragment, "radio_player")
            .addToBackStack(null)
            .commit()

    }
}
