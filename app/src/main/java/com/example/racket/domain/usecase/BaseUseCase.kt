package com.example.racket.domain.usecase

interface BaseUseCase<inPut, outPut> {

    suspend fun execute(input: inPut): outPut
}