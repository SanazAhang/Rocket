package com.example.racket.domain.repository.rocket

import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData

interface RocketRepository {

    suspend fun get():ResultData<List<Model.Rocket>>
}