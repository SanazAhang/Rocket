package com.example.racket.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Model {

    @Parcelize
    data class Rocket(
        val id: Int,
        val active: Boolean,
        val stages: Int,
        val boosters: Int,
        val successRatePct: String,
        val firstFlight: String,
        val country: String,
        val company: String,
        val description: String,
        val rocketId: String,
        val rocketName: String,
        val rocketType: String,
        val flickrImage: String
    ) : Model(),Parcelable
}
