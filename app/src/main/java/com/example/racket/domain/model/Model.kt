package com.example.racket.domain.model

import com.example.racket.data.network.api.Dto
import com.squareup.moshi.Json

sealed class Model {
    data class Rocket(
        val id: Int,
        val active: Boolean,
        val stages: Int,
        val boosters: Int,
        val costPerLaunch: Int,
        val successRatePct: Int,
        val firstFlight: String,
        val country: String,
        val company: String,
        val flickrImages: List<String>,
        val description: String,
        val rocketId: String,
        val rocketName: String,
        val rocketType: String
//        val height: Height,
//        val diameter: Diameter,
//        val mass: Mass,
//        val firstStage: FirstStage,
//        val secondStage: SecondStage,
//        val engines: Engines,
    ) : Model()
}
