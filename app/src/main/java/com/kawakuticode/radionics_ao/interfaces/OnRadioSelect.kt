package com.kawakuticode.radionics_ao.interfaces

import com.kawakuticode.radionics_ao.models.Radio_Station

interface OnRadioSelect {
    fun onRadioSelected(radioModel: Radio_Station)
}