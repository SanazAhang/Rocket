package com.example.racket.di

import com.example.racket.data.dataSource.rocket.RocketRemoteDataSource
import com.example.racket.data.dataSource.rocket.RocketRemoteDataSourceImp
import com.example.racket.data.network.api.RocketApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun rocketRemoteDataSource(rocketApi: RocketApi):RocketRemoteDataSource =
        RocketRemoteDataSourceImp(rocketApi)
}