package com.example.racket.domain.usecase.rocket

import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.repository.rocket.RocketRepository

class FakeRepository(private val rockets:List<Model.Rocket>): RocketRepository {
    override suspend fun get(): ResultData<List<Model.Rocket>> {
        return ResultData.Success(rockets)
    }
}