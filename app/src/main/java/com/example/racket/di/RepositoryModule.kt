package com.example.racket.di

import com.example.racket.data.dataSource.rocket.RocketRemoteDataSource
import com.example.racket.domain.repository.rocket.RocketRepository
import com.example.racket.domain.repository.rocket.RocketRepositoryImp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun getRocket(rocketRemoteDataSource: RocketRemoteDataSource) : RocketRepository =
        RocketRepositoryImp(rocketRemoteDataSource)
}