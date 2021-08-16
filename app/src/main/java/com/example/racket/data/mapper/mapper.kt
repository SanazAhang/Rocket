package com.example.racket.data.mapper

import com.example.racket.data.network.api.Dto
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import retrofit2.Response

inline fun <T> execute(request: () -> Response<T>): ResultData<T> =
    try {
        val response = request()
        if (response.isSuccessful) {
            ResultData.Success(response.body()!!)
        } else {
            ResultData.Failure(response.message())
        }
    } catch (ex: Exception) {
        ResultData.Error(ex)
    }

fun Dto.Rocket.mapToModel() = Model.Rocket(
    id = id,
    active = active,
    boosters = boosters,
    company = company,
    country = country,
    description = description,
    firstFlight = firstFlight,
    rocketId = rocketId,
    rocketName = rocketName,
    rocketType = rocketType,
    stages = stages,
    successRatePct = successRatePct.toString(),
    flickrImage = flickr_images[0]
)