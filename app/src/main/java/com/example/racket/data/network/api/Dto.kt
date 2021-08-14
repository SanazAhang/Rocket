package com.example.racket.data.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class Dto {

    @JsonClass(generateAdapter = true)
    data class result(
        val rockets: List<Rocket>
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Rocket(
        @Json(name = "id") val id: Int,
        @Json(name = "active") val active: Boolean,
        @Json(name = "stages") val stages: Int,
        @Json(name = "boosters") val boosters: Int,
        @Json(name = "cost_per_launch") val costPerLaunch: Int,
        @Json(name = "success_rate_pct") val successRatePct: Int,
        @Json(name = "first_flight") val firstFlight: String,
        @Json(name = "country") val country: String,
        @Json(name = "company") val company: String,
        @Json(name = "height") val height: Height,
        @Json(name = "diameter") val diameter: Diameter,
        @Json(name = "mass") val mass: Mass,
        @Json(name = "first_stage") val firstStage: FirstStage,
        @Json(name = "second_stage") val secondStage: SecondStage,
        @Json(name = "engines") val engines: Engines,
        @Json(name = "flickr_images") val flickrImages: List<String>,
        @Json(name = "description") val description: String,
        @Json(name = "rocket_id") val rocketId: String,
        @Json(name = "rocket_name") val rocketName: String,
        @Json(name = "rocket_type") val rocketType: String
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Height(
        @Json(name = "meters") val meters: Double,
        @Json(name = "feet") val feet: Double
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Diameter(
        @Json(name = "meters") val meters: Double,
        @Json(name = "feet") val feet: Double
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Mass(
        @Json(name = "kg") val kg: Int,
        @Json(name = "lb") val lb: Int
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class FirstStage(
        @Json(name = "reusable") val reusable: Boolean,
        @Json(name = "engines") val engines: Int,
        @Json(name = "fuel_amount_tons") val fuelAmountTons: Double,
        @Json(name = "burn_time_sec") val burnTimeSec: Int,
        @Json(name = "thrust_sea_level") val thrustSeaLevel: ThrustSeaLevel,
        @Json(name = "thrust_vacuum") val thrustVacuum: ThrustVacuum
    ) : Dto()

    data class ThrustSeaLevel(
        @Json(name = "kN") val kN: Int,
        @Json(name = "lbf") val lbf: Int
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class ThrustVacuum(
        @Json(name = "kN") val kN: Int,
        @Json(name = "lbf") val lbf: Int
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class SecondStage(
        @Json(name = "reusable") val reusable: Boolean,
        @Json(name = "engines") val engines: Int,
        @Json(name = "fuel_amount_tons") val fuelAmountTons: Double,
        @Json(name = "burn_time_sec") val burnTimeSec: Int,
        @Json(name = "thrust") val thrust: Thrust,
        @Json(name = "payloads") val payloads: Payloads
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Thrust(
        @Json(name = "kN") val kN: Int,
        @Json(name = "lbf") val lbf: Int
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Payloads(
        @Json(name = "option_1") val optionOne: String,
        @Json(name = "composite_fairing") val compositeFairing: CompositeFairing
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class CompositeFairing(
        @Json(name = "height") val height: Height,
        @Json(name = "diameter") val diameter: Diameter
    )

    @JsonClass(generateAdapter = true)
    data class Engines(
        @Json(name = "number") val number: Int,
        @Json(name = "type") val type: String,
        @Json(name = "version") val version: String,
        @Json(name = "layout") val layout: String,
        @Json(name = "isp") val isp: Isp,
        @Json(name = "engine_loss_max") val engineLossMax: Int,
        @Json(name = "propellant_1") val propellantOne: String,
        @Json(name = "propellant_2") val propellantTwo: String,
        @Json(name = "thrust_sea_level") val thrustSeaLevel: ThrustSeaLevel,
        @Json(name = "thrust_vacuum") val thrustVacuum: ThrustVacuum,
        @Json(name = "thrust_to_weight") val thrustToWeight: Int
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Isp (
        @Json(name = "sea_level") val seaLevel : Int,
        @Json(name = "vacuum") val vacuum : Int
    ): Dto()

}
