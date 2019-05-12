package com.yotharit.artistra.ui.main.search.model

import com.squareup.moshi.Json

data class PerformerModel (
    @field:Json(name = "name") val name : String,
    @field:Json(name = "short_bio") val bio : String
)