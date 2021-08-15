package com.example.racket.data.dataSource.rocket

import com.example.racket.data.mapper.execute
import com.example.racket.data.mapper.mapToModel
import com.example.racket.data.network.api.RocketApi
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.model.map

class RocketRemoteDataSourceImp(private val rocketApi: RocketApi) : RocketRemoteDataSource {

    override suspend fun getData(): ResultData<List<Model.Rocket>> = execute {
        rocketApi.getRockets()
    }.map { rockets ->
        rockets.map { rocket ->
            rocket.mapToModel()
        }

    }
}