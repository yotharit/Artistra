package com.yotharit.artistra.ui.main.search.model

import com.squareup.moshi.Json
import retrofit2.http.Field

data class EventsModel (
    @field:Json(name="event") val event : List<EventModel>
)