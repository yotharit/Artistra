package com.yotharit.artistra.ui.main.search.model

import com.squareup.moshi.Json

data class PerformersModel (
    @field:Json(name = "performer") val performer : PerformerModel
)
