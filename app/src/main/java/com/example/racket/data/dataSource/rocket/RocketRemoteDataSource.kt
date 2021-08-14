package com.example.racket.data.dataSource.rocket

import com.example.racket.data.dataSource.RemoteDataSource
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData

interface RocketRemoteDataSource : RemoteDataSource<Model.Rocket> {

    suspend fun getData(): ResultData<List<Model.Rocket>>
}