package com.example.racket.domain.repository.rocket

import com.example.racket.data.dataSource.rocket.RocketRemoteDataSource
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData

class RocketRepositoryImp(private val rocketRemoteDataSource: RocketRemoteDataSource):RocketRepository {

    override suspend fun get(): ResultData<List<Model.Rocket>> {
        return rocketRemoteDataSource.getData()
    }
}