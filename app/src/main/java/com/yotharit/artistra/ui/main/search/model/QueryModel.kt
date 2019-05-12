package com.yotharit.artistra.ui.main.search.model

import com.squareup.moshi.Json

data class QueryModel(
    @field:Json(name = "total_items") val totalItem: String,
    @field:Json(name = "page_size") val pageSize: String,
    @field:Json(name = "events") val eventList : EventsModel
)