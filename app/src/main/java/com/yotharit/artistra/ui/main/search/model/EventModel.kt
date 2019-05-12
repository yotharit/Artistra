package com.yotharit.artistra.ui.main.search.model

import com.squareup.moshi.Json

data class EventModel(
    @field:Json(name = "title") val eventName: String,
    @field:Json(name = "venue_name") val venueName: String,
    @field:Json(name = "start_time") val time : String,
    @field:Json(name = "latitude") val latitude : String,
    @field:Json(name = "longitude") val longitude : String,
    @field:Json(name = "country_name") val countryName : String,
    @field:Json(name = "country_abbr") val countryAbbr : String,
    @field:Json(name = "description") val description : String,
    @field:Json(name = "city_name") val cityName : String,
    @field:Json(name = "id") val id : String
    )