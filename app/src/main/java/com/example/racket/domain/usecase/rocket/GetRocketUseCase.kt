package com.example.racket.domain.usecase.rocket

import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.repository.rocket.RocketRepository
import com.example.racket.domain.usecase.BaseUseCase

class GetRocketUseCase(private val rocketRepository: RocketRepository):BaseUseCase<Unit,ResultData<List<Model.Rocket>>> {

    override suspend fun execute(input: Unit): ResultData<List<Model.Rocket>> {
       return rocketRepository.get()
    }
}