package com.example.racket.di

import com.example.racket.domain.repository.rocket.RocketRepository
import com.example.racket.domain.usecase.rocket.GetRocketUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun getRocketUseCase(rocketRepository: RocketRepository):GetRocketUseCase =
        GetRocketUseCase(rocketRepository)

}