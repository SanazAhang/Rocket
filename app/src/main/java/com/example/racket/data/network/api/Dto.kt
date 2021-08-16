package com.example.racket.data.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class Dto {

    @JsonClass(generateAdapter = true)
    data class Rocket(
        @Json(name = "id") val id: Int,
        @Json(name = "active") val active: Boolean,
        @Json(name = "stages") val stages: Int,
        @Json(name = "boosters") val boosters: Int,
        @Json(name = "success_rate_pct") val successRatePct: Int,
        @Json(name = "first_flight") val firstFlight: String,
        @Json(name = "country") val country: String,
        @Json(name = "company") val company: String,
        @Json(name = "description") val description: String,
        @Json(name = "rocket_id") val rocketId: String,
        @Json(name = "rocket_name") val rocketName: String,
        @Json(name = "rocket_type") val rocketType: String,
        @Json(name = "flickr_images") val flickr_images: List<String>,
    ) : Dto()
}
