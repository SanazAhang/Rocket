package com.example.racket.ui.rocketList

import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.usecase.BaseUseCase

class FakeUseCase(private val status: String) : BaseUseCase<Unit, ResultData<List<Model.Rocket>>> {
    override suspend fun execute(input: Unit): ResultData<List<Model.Rocket>> {
        return when (status) {
            "Success" -> {
                val data = listOf<Model.Rocket>()
                ResultData.Success(data)
            }
            "Failure" -> {
                ResultData.Failure("Failure")
            }
            else -> {
                ResultData.Error(Throwable())
            }
        }
    }
}