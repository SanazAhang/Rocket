package com.example.racket.data.network.api

import retrofit2.Response
import retrofit2.http.GET

interface RocketApi {

    @GET("rockets")
    suspend fun getRockets():Response<Dto.result>
}