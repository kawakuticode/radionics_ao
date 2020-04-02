package com.kawakuticode.radionics_ao.models

import kotlinx.serialization.Serializable

@Serializable
data class Radio_Station(
    var name: String,
    var station_url: String,
    var stream_link: String,
    var logo_url: String
) : java.io.Serializable


